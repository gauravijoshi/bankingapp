package com.xoriant.banking.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.xoriant.banking.DTO.ResponseDTO;

public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentInvalid(MethodArgumentNotValidException exception) {
		HashMap<String, String> errors  = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMsg = error.getDefaultMessage();
			errors.put(fieldName, errorMsg);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				ResponseDTO.builder()
				.message("Some fields have invalid values")
				.success(Boolean.FALSE)
				.data(errors)
				.build()
		);
	}
}
