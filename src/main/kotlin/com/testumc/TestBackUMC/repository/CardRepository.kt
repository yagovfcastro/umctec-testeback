package com.testumc.TestBackUMC.repository

import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.service.CardService
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository : JpaRepository<Card, Long> {

  fun findAllByActivityId(activityId: Long): List<Card>

  fun findAllByActivityId(activityId: Long, pageable: Pageable): List<Card>

  fun findAllByActivityIdAndPatientPatientName(activityId: Long, patientName: String?, pageable: Pageable): List<Card>
}