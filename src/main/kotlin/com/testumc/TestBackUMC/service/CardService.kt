package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.CardsResponseDTO
import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.entity.Activity
import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.entity.SlaStatus
import com.testumc.TestBackUMC.entity.SlaStatus.*
import com.testumc.TestBackUMC.repository.ActivityRepository
import com.testumc.TestBackUMC.repository.CardRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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

  fun updateSlaStat(cardId: Long, slaStatus: SlaStatus) = this.cardRepository.updateSlaStatus(cardId, slaStatus)

  fun updateCardsSlaStatusesAndQuantity(activityId: Long): IntArray {
    val allCardsFromActivity =  this.cardRepository.findAllByActivityId(activityId)
    val activity: Activity = this.activityRepository.findById(activityId).get()
    val currentDate = LocalDateTime.now()

    // Right below is a Datetime you can use for tests
    // val currentDate = LocalDateTime.now().plusDays(10)

    val totalCardsList = IntArray(3)

    for (card in allCardsFromActivity) {
      val cardCreationDate = card.createdAt
      val daysInBetween = cardCreationDate.until(currentDate, ChronoUnit.DAYS)

      if (daysInBetween < (activity.sla * 75) / 100) {
        updateSlaStat(card.cardId, OK)
        totalCardsList[0] += 1
      } else if (daysInBetween <= activity.sla && daysInBetween > (activity.sla * 75) / 100) {
        updateSlaStat(card.cardId, WARNING)
        totalCardsList[1] += 1
      } else {
        updateSlaStat(card.cardId, DELAYED)
        totalCardsList[2] += 1
      }
    }

    return totalCardsList
  }

  fun executeFilterPatientName(activityId: Long, patientName: String?, paging: Pageable, filter: String): List<Card> {
    if (patientName == null) {
      return when (filter) {
        "PRIORITY" -> this.cardRepository.findAllByActivityId(activityId, paging)
        "TO_RECEIVE" -> this.cardRepository.findAllByActivityId(activityId, paging).filter { it.numberOfNotReceivedDocuments != 0 }
        else -> this.cardRepository.findAllByActivityId(activityId, paging).filter {
          it.numberOfNotReceivedDocuments == 0 &&
            it.numberOfChecklistItem == it.numberOfDoneChecklistItem &&
            it.numberOfOpenPendencies == 0}
      }
    }

    return when (filter) {
      "PRIORITY" -> this.cardRepository.findAllByActivityIdAndPatientPatientName(activityId, patientName, paging)
      "TO_RECEIVE" -> this.cardRepository.findAllByActivityIdAndPatientPatientName(activityId, patientName, paging).filter { it.numberOfNotReceivedDocuments != 0 }
      else -> this.cardRepository.findAllByActivityIdAndPatientPatientName(activityId, patientName, paging).filter { it.numberOfNotReceivedDocuments == 0 &&
        it.numberOfChecklistItem == it.numberOfDoneChecklistItem && it.numberOfOpenPendencies == 0}
    }
  }

  fun listByActivityIdAndPatientName(activityId: Long, patientName: String?, filter: String, page: Int, size: Int) : CardsResponseDTO {
    val paging: Pageable = PageRequest.of(page, size, Sort.by("slaStatus").descending())
    val totalCardsList = updateCardsSlaStatusesAndQuantity(activityId)
    val totalCardsOk = totalCardsList[0]
    val totalCardsWarning = totalCardsList[1]
    val totalCardsDelayed = totalCardsList[2]

    val cardsResponseDTO = CardsResponseDTO()
    cardsResponseDTO.totalCardsOk = totalCardsOk
    cardsResponseDTO.totalCardsWarning = totalCardsWarning
    cardsResponseDTO.totalCardsDelayed = totalCardsDelayed

    cardsResponseDTO.cards = executeFilterPatientName(activityId, patientName, paging, filter)

    return cardsResponseDTO
  }

//  fun listByActivityIdAndBillBillId(activityId: Long, billId: Long?, filter: String, page: Int, size: Int) : CardsResponseDTO {
//    val paging: Pageable = PageRequest.of(page, size, Sort.by("slaStatus").descending())
//    val totalCardsList = updateCardsSlaStatusesAndQuantity(activityId)
//    val totalCardsOk = totalCardsList[0]
//    val totalCardsWarning = totalCardsList[1]
//    val totalCardsDelayed = totalCardsList[2]
//
//    val cardsResponseDTO = CardsResponseDTO()
//    cardsResponseDTO.totalCardsOk = totalCardsOk
//    cardsResponseDTO.totalCardsWarning = totalCardsWarning
//    cardsResponseDTO.totalCardsDelayed = totalCardsDelayed
//
//    cardsResponseDTO.cards = this.cardRepository.findAllByActivityIdAndBillBillId(activityId, billId, paging)
//
//    return cardsResponseDTO
//  }

}