package com.testumc.TestBackUMC.repository

import com.testumc.TestBackUMC.entity.Patient
import org.springframework.data.repository.CrudRepository

interface PatientRepository : CrudRepository<Patient, Long> {
}