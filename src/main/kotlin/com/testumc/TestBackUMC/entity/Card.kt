package com.testumc.TestBackUMC.entity

import com.testumc.TestBackUMC.enumerator.SlaStatus
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Card")
class Card ( // Still confused about visitId
  @Id @GeneratedValue
  val cardId: Long = 0L,
  val activityId: Long,
  var slaStatus: SlaStatus,
  val createdAt: LocalDateTime,
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