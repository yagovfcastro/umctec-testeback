package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.CreateActivityDTO
import com.testumc.TestBackUMC.entity.Activity
import com.testumc.TestBackUMC.repository.ActivityRepository
import org.joda.time.DateTime
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ActivityService(val activityRepository: ActivityRepository) {

  fun store(activity: CreateActivityDTO): Activity{
    val newActivity = Activity(
      activityTitle = activity.activityTitle,
      activitySubTitle = activity.activitySubTitle,
      createdAt = LocalDateTime.now(),
      sla = activity.sla
      )
    return this.activityRepository.save(newActivity)
  }

  fun listAllActivities() = this.activityRepository.findAll()
}