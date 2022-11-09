package com.example.employeeapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmployeeAppApplication

fun main(args: Array<String>) {
	runApplication<EmployeeAppApplication>(*args)
}
