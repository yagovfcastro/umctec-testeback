package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.CardsResponseDTO
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

  fun listByActivityIdAndPatientName(activityId: Long, patientName: String?, page: Int, size: Int) : CardsResponseDTO {
    val paging: Pageable = PageRequest.of(page, size)
    val activity: Activity = this.activityRepository.findById(activityId).get()
    val cardsResponseDTO: CardsResponseDTO = CardsResponseDTO()

    val totalCardsList = updateCardsSlaStatuses(activityId)
    val totalCardsOk = totalCardsList[0]
    val totalCardsWarning = totalCardsList[1]
    val totalCardsDelayed = totalCardsList[2]


    cardsResponseDTO.totalCardsOk = totalCardsOk
    cardsResponseDTO.totalCardsWarning = totalCardsWarning
    cardsResponseDTO.totalCardsDelayed = totalCardsDelayed

    if (patientName == null) {
      cardsResponseDTO.cards = this.cardRepository.findAllByActivityId(activityId, paging)
      return cardsResponseDTO
    }

    cardsResponseDTO.cards = this.cardRepository.findAllByActivityIdAndPatientPatientName(activityId, patientName, paging)

    return cardsResponseDTO
  }

  // Updates the slaStatus of the Card
  // It counts and returns the total cards Ok, Warning and Delayed
  fun updateCardsSlaStatuses(activityId: Long): IntArray {
    val allCardsFromActivity =  this.cardRepository.findAllByActivityId(activityId)
    val activity: Activity = this.activityRepository.findById(activityId).get()
    val currentDate = LocalDateTime.now()

    var totalCardsList = IntArray(3)

    for (card in allCardsFromActivity) {
      val cardCreationDate = card.createdAt
      val daysInBetween = cardCreationDate.until(currentDate, ChronoUnit.DAYS)

      if (daysInBetween < (activity.sla * 75) / 100) {
        this.cardRepository.findById(card.cardId).get().slaStatus = OK
        totalCardsList[0] += 1
      } else if (daysInBetween <= activity.sla && daysInBetween > (activity.sla * 75) / 100) {
        this.cardRepository.findById(card.cardId).get().slaStatus = WARNING
        totalCardsList[1] += 1
      } else {
        this.cardRepository.findById(card.cardId).get().slaStatus = DELAYED
        totalCardsList[2] += 1
      }
    }

    return totalCardsList
  }

  // Hand written filter, using the filter function

}