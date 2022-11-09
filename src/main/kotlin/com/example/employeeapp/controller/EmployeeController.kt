package com.example.employeeapp.controller

import com.example.employeeapp.repository.model.Employee
import com.example.employeeapp.service.EmployeeService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Victor Teka on 08/11/2022.
 */

@RestController
class EmployeeController(
    private val employeeService: EmployeeService
) {

    @GetMapping("/employees")
    fun getEmployees(): List<Employee> = employeeService.getAllEmployees()

    @GetMapping("/employees/{id}")
    fun getEmployeeById(
        @PathVariable("id") employeeId: Long
    ): Employee {
        return employeeService.getEmployeeById(employeeId)
    }

    @PostMapping("/employees")
    fun createEmployee(
        @RequestBody payload: Employee
    ): Employee = employeeService.createEmployee(payload)

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(
        @PathVariable("id") employeeId: Long,
        @RequestBody payload: Employee
    ): Employee {
        return employeeService.updateEmployeeById(employeeId, payload)
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeeById(
        @PathVariable("id") employeeId: Long
    )  = employeeService.deleteEmployeeById(employeeId)
}