package com.testumc.TestBackUMC.repository

import com.testumc.TestBackUMC.entity.Bill
import org.springframework.data.repository.CrudRepository

interface BillRepository : CrudRepository<Bill, Long> {
}