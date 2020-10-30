package com.testumc.TestBackUMC.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Card")
class Card ( // Lacks visitId, I need to know what it is
  @Id @GeneratedValue val cardId: Long = 0L,
  val activityId: Long,
  val createdAt: Date,
  val patient: Patient,
  val healthInsurance: HealthInsurance,
  val bill: Bill,
  val totalAmount: Double,
  val numberOfPendencies: Int,
  val numberOfOpenPendencies: Int,
  val numberOfDocuments: Int,
  val numberOfNotReceivedDocuments: Int,
  val numberOfChecklistItem: Int,
  val numberOfDoneChecklistItem: Int
)