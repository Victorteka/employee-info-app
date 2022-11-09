package com.example.employeeapp.exception

import org.springframework.http.HttpStatus

/**
 * Created by Victor Teka on 08/11/2022.
 */

class EmployeeNotFoundException(
    val statusCode: HttpStatus,
    val reason: String
): Exception()