package com.testumc.TestBackUMC.entity

import javax.persistence.GeneratedValue
import javax.persistence.Id

enum class BillType {
  HOSPITALAR, AMBULATORIAL
}

class Bill (
  @Id @GeneratedValue val billId: Long = 0L,
  val billType: BillType
)