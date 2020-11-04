package com.testumc.TestBackUMC.repository

import com.testumc.TestBackUMC.entity.Activity
import org.springframework.data.repository.CrudRepository

interface ActivityRepository : CrudRepository<Activity, Long>{
}