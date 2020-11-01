package com.testumc.TestBackUMC.dto

import com.testumc.TestBackUMC.entity.Card

data class CardsResponseDTO (
  var cards: List<Card>? = null,
  var totalCardsOk: Int = 0,
  var totalCardsWarning: Int = 0,
  var totalCardsDelayed: Int = 0
)