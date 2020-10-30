package com.testumc.TestBackUMC.entity

import javax.persistence.*

@Embeddable
class Bill (
  @Id @GeneratedValue val billId: Long = 0L,
  val billType: String,
  val billPrice: Double
)