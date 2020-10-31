package com.testumc.TestBackUMC.repository

import com.testumc.TestBackUMC.entity.Card
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository : JpaRepository<Card, Long> {


  fun findAllByActivityId(activityId: Long, pageable: Pageable): List<Card>
}