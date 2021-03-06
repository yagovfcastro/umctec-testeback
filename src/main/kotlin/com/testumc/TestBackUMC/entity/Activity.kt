package com.testumc.TestBackUMC.entity

import java.time.LocalDateTime
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table

@Entity
@Table(name = "Activity")
class Activity(
  @Id @GeneratedValue val activityId: Long = 0L,
  val activityTitle: String,
  val activitySubTitle: String,
  val createdAt: LocalDateTime,
  val sla: Int,
)