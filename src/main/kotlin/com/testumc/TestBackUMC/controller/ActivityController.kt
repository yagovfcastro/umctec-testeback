package com.testumc.TestBackUMC.controller

import com.testumc.TestBackUMC.dto.CreateActivityDTO
import com.testumc.TestBackUMC.service.ActivityService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/activities")
class ActivityController(val activityService: ActivityService) {

  @PostMapping
  private fun create(@RequestBody activity: CreateActivityDTO) = this.activityService.store(activity)

  @GetMapping
  private fun getAll() = this.activityService.listAll()

}