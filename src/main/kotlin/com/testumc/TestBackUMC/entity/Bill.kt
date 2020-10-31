package com.testumc.TestBackUMC.entity

import javax.persistence.*

enum class BillType {
  HOSPITALAR, AMBULATORIAL
}

@Embeddable
class Bill (
  @GeneratedValue val billId: Long = 0L,
  val billType: BillType,
  val billPrice: Double
)