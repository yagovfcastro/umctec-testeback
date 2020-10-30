package com.testumc.TestBackUMC.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Card (
  @Id @GeneratedValue val cardId: Long = 0L,
  val createdAt: Date,
  val slaStatus: String,
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