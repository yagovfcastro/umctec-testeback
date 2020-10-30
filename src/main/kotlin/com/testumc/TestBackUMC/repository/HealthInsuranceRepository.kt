package com.testumc.TestBackUMC.repository

import com.testumc.TestBackUMC.entity.HealthInsurance
import org.springframework.data.repository.CrudRepository

interface HealthInsuranceRepository : CrudRepository<HealthInsurance, Long> {
}