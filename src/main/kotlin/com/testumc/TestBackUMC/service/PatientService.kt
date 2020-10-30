package com.testumc.TestBackUMC.service

import com.testumc.TestBackUMC.dto.PatientDTO
import com.testumc.TestBackUMC.entity.Patient
import com.testumc.TestBackUMC.repository.PatientRepository

class PatientService(val patientRepository: PatientRepository) {

  fun store(patient: PatientDTO) : Patient {
    val newPatient = Patient(name = patient.name)

    return this.patientRepository.save(newPatient)
  }

}