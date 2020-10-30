package com.testumc.TestBackUMC.entity

import javax.persistence.*

@Embeddable
class HealthInsurance(
  val healthInsuranceId: Long,
  val healthInsuranceName: String
)