package com.testumc.TestBackUMC.repository

import com.testumc.TestBackUMC.entity.Card
import org.springframework.data.repository.CrudRepository

interface CardRepository : CrudRepository<Card, Long> {
}