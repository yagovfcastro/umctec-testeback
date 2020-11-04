package com.testumc.TestBackUMC

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories

class TestBackUmcApplication

fun main(args: Array<String>) {
  runApplication<TestBackUmcApplication>(*args)
}
