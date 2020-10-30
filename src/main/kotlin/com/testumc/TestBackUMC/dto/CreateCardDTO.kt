package com.testumc.TestBackUMC.dto

import com.testumc.TestBackUMC.entity.Bill
import com.testumc.TestBackUMC.entity.HealthInsurance
import com.testumc.TestBackUMC.entity.Patient
import java.util.*

class CreateCardDTO (
  val activityId: Long,
  val patient: Patient,
  val healthInsurance: HealthInsurance,
  val bill: Bill,
  val numberOfPendencies: Int,
  val numberOfOpenPendencies: Int,
  val numberOfDocuments: Int,
  val numberOfNotReceivedDocuments: Int,
  val numberOfChecklistItem: Int,
  val numberOfDoneChecklistItem: Int
  )