package com.testumc.TestBackUMC.entity

import javax.persistence.*

@Embeddable
class Patient (
  @GeneratedValue val patientId: Long = 0L,
  val patientName: String
)