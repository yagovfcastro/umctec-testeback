package com.testumc.TestBackUMC.controller

import com.testumc.TestBackUMC.dto.CardsResponseDTO
import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.service.CardService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cards")
class CardController(val cardService: CardService) {

  @PostMapping
  private fun createCard(@RequestBody card: CreateCardDTO) = this.cardService.store(card)

  @GetMapping("/{activityId}/{page}/{size}")
  private fun getByActivityId(@PathVariable activityId: Long, @PathVariable page: Int, @PathVariable size: Int): List<Card>{
    // Create a new CardsResponseDTO and set its values

    return this.cardService.listByActivityId(activityId, page, size)
  }

  // You have to learn how to deal with a filter


}