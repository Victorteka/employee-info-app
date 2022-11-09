package com.example.employeeapp.repository

import com.example.employeeapp.repository.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Victor Teka on 08/11/2022.
 */

@Repository
interface EmployeeRepository: JpaRepository<Employee, Long>