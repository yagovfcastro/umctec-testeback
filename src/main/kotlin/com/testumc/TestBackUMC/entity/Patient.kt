package com.testumc.TestBackUMC.entity

import javax.persistence.GeneratedValue
import javax.persistence.Id

class Patient (
  @Id @GeneratedValue val patientId: Long = 0L,
  val name: String
)