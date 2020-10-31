package com.testumc.TestBackUMC.controller

import com.testumc.TestBackUMC.dto.CardsResponseDTO
import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.service.CardService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/activities/cards")
class CardController(val cardService: CardService) {

  @PostMapping
  private fun createCard(@RequestBody card: CreateCardDTO) = this.cardService.store(card)

  @GetMapping
  private fun getAll() = this.cardService.listAllCards()

  @GetMapping("/{id}")
  private fun getByActivityId(@PathVariable id: Long): List<Card>{

    return this.cardService.listByActivityId(id)
  }

  // You have to learn how to deal with a filter


}