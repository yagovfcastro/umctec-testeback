package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.entity.SlaStatus.*
import com.testumc.TestBackUMC.repository.CardRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CardService(val cardRepository: CardRepository) {

  fun store(card: CreateCardDTO): Card {

    val newCard = Card(
      activityId = card.activityId,
      createdAt = Date(),
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

  fun listByActivityId(activityId: Long, page: Int, size: Int) : List<Card> {
    val paging: Pageable = PageRequest.of(page, size)

    return this.cardRepository.findAllByActivityId(activityId, paging)
  }

}