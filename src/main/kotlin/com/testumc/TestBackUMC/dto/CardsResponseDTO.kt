package com.testumc.TestBackUMC.dto

import com.testumc.TestBackUMC.entity.Card

data class CardsResponseDTO (
  val cards: List<Card>,
  val totalCardsOk: Int,
  val totalCardsWarning: Int,
  val totalCardsDelayed: Int
)