package com.testumc.TestBackUMC.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Card")
class Card ( // Lacks visitId, I need to know what it is
  @Id @GeneratedValue
  val cardId: Long = 0L,
  val activityId: Long,
  val createdAt: Date,
  @Embedded
  val patient: Patient,
  @Embedded
  val healthInsurance: HealthInsurance,
  @Embedded
  val bill: Bill,
  val totalAmount: Double,
  val numberOfPendencies: Int,
  val numberOfOpenPendencies: Int,
  val numberOfDocuments: Int,
  val numberOfNotReceivedDocuments: Int,
  val numberOfChecklistItem: Int,
  val numberOfDoneChecklistItem: Int
)