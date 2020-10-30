package com.testumc.TestBackUMC.controller

import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.service.CardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/activities/cards")
class CardController(val cardService: CardService) {

  @PostMapping
  private fun createCard(@RequestBody card: CreateCardDTO) = this.cardService.store(card)

  // Activity ID
//  @GetMapping

  // Query:
//  @GetMapping

  // You have to learn how to deal with a filter


}