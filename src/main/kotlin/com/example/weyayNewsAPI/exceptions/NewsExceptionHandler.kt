package com.example.weyayNewsAPI.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*


//@ControllerAdvice
//class NewsExceptionsHandler : ResponseEntityExceptionHandler() {
//
//    @ExceptionHandler(EntityNotFoundException.class)
//            ResonseEntity<>

//    fun createErrorResponseEntity(
//        httpStatus: HttpStatus,
//        errorResponseEntity: ErrorResponseEntity) = ResponseEntity
//        .status(httpStatus)
//        .contentType(MediaType.APPLICATION_PROBLEM_JSON)
//        .body(errorResponseEntity)
//    @ExceptionHandler
//    fun HandleBadRequestException(e : BadRequestException ) = createErrorResponseEntity(
//        HttpStatus.BAD_REQUEST,
//        ErrorResponseEntity(
//            timestamp = Date(),
//            title = "Bad Request",
//            detail = "Invalid request body."
//        )
//    )
//}