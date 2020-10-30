package com.testumc.TestBackUMC.controller

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

  @GetMapping("/test")
  private fun getByActivityId1(@RequestParam("activityId") activityId: Long): List<Card> {

    val allCards = getAll()
    val listCards: MutableList<Card> = mutableListOf()

    for (card in listCards) {
      if (card.activityId == activityId) {
        listCards.add(card)
      }
    }

    return listCards
  }

  @GetMapping("/yago/{id}")
  private fun getByActivityId(@PathVariable id: Long) {
    val listOfCards: List<Card> = listOf()


  }

  // You have to learn how to deal with a filter


}