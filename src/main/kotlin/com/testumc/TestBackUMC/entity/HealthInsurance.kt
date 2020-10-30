package com.testumc.TestBackUMC.entity

import org.springframework.data.annotation.Id
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table

@Embeddable
class HealthInsurance(
  @Id @GeneratedValue val healthInsuranceId: Long = 0L,
  val name: String
)