package com.testumc.TestBackUMC.controller

import com.testumc.TestBackUMC.dto.CardsResponseDTO
import com.testumc.TestBackUMC.dto.CreateCardDTO
import com.testumc.TestBackUMC.service.CardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cards")
class CardController(val cardService: CardService) {

  @PostMapping
  private fun createCard(@RequestBody card: CreateCardDTO) = this.cardService.store(card)

  @GetMapping("/{activityId}")
  private fun getCardsN(@PathVariable(value = "activityId") activityId: Long,
                       @RequestParam(value = "patientName", required = false) patientName: String,
                       @RequestParam(value = "filter", defaultValue = "PRIORITY", required = false) filter: String,
                       @RequestParam(value = "page", defaultValue = "0", required = false) page: Int,
                       @RequestParam(value = "size", defaultValue = "12", required = false) size: Int): CardsResponseDTO{

    return this.cardService.listByActivityIdAndPatientName(activityId, patientName, filter, page, size)
  }

}