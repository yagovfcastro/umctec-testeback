package com.testumc.TestBackUMC.repository

import com.testumc.TestBackUMC.entity.Card
import com.testumc.TestBackUMC.entity.SlaStatus
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface CardRepository : JpaRepository<Card, Long> {

  fun findAllByActivityId(activityId: Long): List<Card>

  fun findAllByActivityId(activityId: Long, pageable: Pageable): List<Card>

  fun findAllByActivityIdAndPatientPatientName(activityId: Long, patientName: String?, pageable: Pageable): List<Card>

  fun findAllByActivityIdAndBillBillId(activityId: Long, billId: Long?, pageable: Pageable): List<Card>

  fun findAllByActivityIdAndBillVisitId(activityId: Long, visitId: Long?, pageable: Pageable): List<Card>

  @Transactional
  @Modifying
  @Query("update Card u set u.slaStatus = :slaStatus where u.cardId = :cardId")
  fun updateSlaStatus(@Param(value = "cardId") cardId: Long, @Param(value = "slaStatus") slaStatus: SlaStatus)
}