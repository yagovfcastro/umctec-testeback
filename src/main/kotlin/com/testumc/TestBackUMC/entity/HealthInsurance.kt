package com.testumc.TestBackUMC.entity

import org.springframework.data.annotation.Id
import javax.persistence.GeneratedValue

class HealthInsurance (
  @Id @GeneratedValue val healthInsuranceId: Long = 0L,
  val name: String
)