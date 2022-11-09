package com.example.employeeapp.service

import com.example.employeeapp.exception.EmployeeNotFoundException
import com.example.employeeapp.repository.EmployeeRepository
import com.example.employeeapp.repository.model.Employee
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

/**
 * Created by Victor Teka on 08/11/2022.
 */

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository
) {

    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    fun getEmployeeById(employeeId: Long) : Employee = employeeRepository.findById(employeeId)
        .orElseThrow { EmployeeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found") }

    fun createEmployee(employee: Employee): Employee = employeeRepository.save(employee)

    fun updateEmployeeById(employeeId: Long, employee: Employee): Employee {
        return if (employeeRepository.existsById(employeeId)){
            employeeRepository.save(Employee(
                id = employee.id,
                userName = employee.userName,
                firstName = employee.firstName,
                middleName = employee.middleName,
                lastName = employee.lastName,
                emailId = employee.emailId,
                dayOfBirth = employee.dayOfBirth
            ))
        } else throw EmployeeNotFoundException(statusCode = HttpStatus.NOT_FOUND, "No matching employee was found")
    }

    fun deleteEmployeeById(employeeId: Long) {
        return if (employeeRepository.existsById(employeeId)){
            employeeRepository.deleteById(employeeId)
        } else throw EmployeeNotFoundException(statusCode = HttpStatus.NOT_FOUND, "No matching employee was found")
    }
}