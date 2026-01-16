//package com.kuganBuilds.TaskTracker.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.time.LocalDateTime;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(TaskNotFoundException.class)
//    public ResponseEntity<ApiError> handleTaskNotFound(TaskNotFoundException ex) {
//
//        ApiError error = new ApiError(
//                HttpStatus.NOT_FOUND.value(),
//                ex.getMessage(),
//                LocalDateTime.now()
//        );
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiError> handleValidationErrors(MethodArgumentNotValidException ex) {
//
//        String errorMessage = ex.getBindingResult()
//                .getFieldErrors()
//                .get(0)
//                .getDefaultMessage();
//
//        ApiError error = new ApiError(
//                HttpStatus.BAD_REQUEST.value(),
//                errorMessage,
//                LocalDateTime.now()
//        );
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
//}
