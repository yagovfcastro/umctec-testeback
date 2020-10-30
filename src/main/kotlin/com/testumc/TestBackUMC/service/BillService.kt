package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.BillDTO
import com.testumc.TestBackUMC.entity.Bill
import com.testumc.TestBackUMC.repository.BillRepository

class BillService(val billRepository: BillRepository) {

  fun store(bill: BillDTO) : Bill {
    val newBill = Bill(billPrice = bill.billPrice, billType = bill.billType)

    return this.billRepository.save(newBill)
  }
}