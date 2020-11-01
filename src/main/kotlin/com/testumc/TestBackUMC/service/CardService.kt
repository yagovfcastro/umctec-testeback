package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.entity.Activity
import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.entity.SlaStatus.*
import com.testumc.TestBackUMC.repository.ActivityRepository
import com.testumc.TestBackUMC.repository.CardRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Service
class CardService(val cardRepository: CardRepository, val activityRepository: ActivityRepository) {

  fun store(card: CreateCardDTO): Card {

    val newCard = Card(
      activityId = card.activityId,
      createdAt = LocalDateTime.now(),
      patient = card.patient,
      bill = card.bill,
      slaStatus = OK,
      totalAmount = card.bill.billPrice,
      healthInsurance = card.healthInsurance,
      numberOfPendencies = card.numberOfPendencies,
      numberOfOpenPendencies = card.numberOfOpenPendencies,
      numberOfDocuments = card.numberOfDocuments,
      numberOfNotReceivedDocuments = card.numberOfNotReceivedDocuments,
      numberOfChecklistItem = card.numberOfChecklistItem,
      numberOfDoneChecklistItem = card.numberOfDoneChecklistItem
    )

    return this.cardRepository.save(newCard)
  }

  fun listByActivityIdAndPatientName(activityId: Long, patientName: String?, page: Int, size: Int) : List<Card> {
    val paging: Pageable = PageRequest.of(page, size)
    val activity: Activity = this.activityRepository.findById(activityId).get()

    updateCardsSlaStatuses(activityId)

    if (patientName == null) {
      return this.cardRepository.findAllByActivityId(activityId, paging)
    }

    return this.cardRepository.findAllByActivityIdAndPatientPatientName(activityId, patientName, paging)
  }

  fun updateCardsSlaStatuses(activityId: Long) {
    val allCardsFromActivity =  this.cardRepository.findAllByActivityId(activityId)
    val activity: Activity = this.activityRepository.findById(activityId).get()
    val currentDate = LocalDateTime.now()

    // Loop to see the slaStatuses and try to change them
    for (card in allCardsFromActivity) {
      val cardCreationDate = card.createdAt
      val daysInBetween = cardCreationDate.until(currentDate, ChronoUnit.DAYS)

      if (daysInBetween < (activity.sla * 75) / 100) {
        this.cardRepository.findById(card.cardId).get().slaStatus = OK
      } else if (daysInBetween <= activity.sla && daysInBetween > (activity.sla * 75) / 100) {
        this.cardRepository.findById(card.cardId).get().slaStatus = WARNING
      } else {
        this.cardRepository.findById(card.cardId).get().slaStatus = DELAYED
      }
    }
  }

}