package com.testumc.TestBackUMC.entity

import javax.persistence.*

@Embeddable
class Bill (
  @GeneratedValue val billId: Long = 0L,
  val billType: String,
  val billPrice: Double
)