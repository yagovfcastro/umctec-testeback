package com.testumc.TestBackUMC.entity

import com.testumc.TestBackUMC.enumerator.BillType
import javax.persistence.*

@Embeddable
class Bill (
  val billId: Long,
  val billType: BillType,
  val billPrice: Double,
  val visitId: Long
)