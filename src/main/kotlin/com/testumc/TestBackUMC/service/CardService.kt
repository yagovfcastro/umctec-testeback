package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.repository.CardRepository
import org.springframework.stereotype.Service


@Service
class CardService(val cardRepository: CardRepository) {

  fun store(card: CreateCardDTO) {

  }
}