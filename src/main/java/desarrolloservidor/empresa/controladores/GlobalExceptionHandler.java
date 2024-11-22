package desarrolloservidor.empresa.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Void> handleNullPointerException(HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> handleIllegalArgumentException(HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Void> handleConstraintViolationException(HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Void> handleHttpMessageNotReadable(HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
