package com.testumc.TestBackUMC.entity

import javax.persistence.*

@Embeddable
class Patient (
  @Id @GeneratedValue val patientId: Long = 0L,
  val name: String
)