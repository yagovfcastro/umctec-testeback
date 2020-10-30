package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.HealthInsuranceDTO
import com.testumc.TestBackUMC.entity.HealthInsurance
import com.testumc.TestBackUMC.repository.HealthInsuranceRepository

class HealthInsuranceService(val healthInsuranceRepository: HealthInsuranceRepository) {

  fun store(healthInsurance: HealthInsuranceDTO) : HealthInsurance {
    val newHealthInsurance = HealthInsurance(name = healthInsurance.name)

    return this.healthInsuranceRepository.save(newHealthInsurance)
  }
}