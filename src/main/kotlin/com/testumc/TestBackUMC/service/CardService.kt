package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.entity.Bill
import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.entity.HealthInsurance
import com.testumc.TestBackUMC.entity.Patient
import com.testumc.TestBackUMC.repository.BillRepository
import com.testumc.TestBackUMC.repository.CardRepository
import com.testumc.TestBackUMC.repository.HealthInsuranceRepository
import com.testumc.TestBackUMC.repository.PatientRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CardService(val cardRepository: CardRepository) {

  fun store(card: CreateCardDTO): Card {

    val newCard = Card(
      activityId = card.activityId,
      createdAt = Date(),
      totalAmount = 30.50,
      numberOfPendencies = card.numberOfPendencies,
      numberOfOpenPendencies = card.numberOfOpenPendencies,
      numberOfDocuments = card.numberOfDocuments,
      numberOfNotReceivedDocuments = card.numberOfNotReceivedDocuments,
      numberOfChecklistItem = card.numberOfChecklistItem,
      numberOfDoneChecklistItem = card.numberOfDoneChecklistItem
    )

    return this.cardRepository.save(newCard)
  }
}