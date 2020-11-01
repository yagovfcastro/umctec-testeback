package com.testumc.TestBackUMC.entity

import javax.persistence.*

enum class BillType {
  HOSPITALAR, AMBULATORIAL
}

@Embeddable
class Bill (
  val billId: Long,
  val billType: BillType,
  val billPrice: Double,
  val visitId: Long
)