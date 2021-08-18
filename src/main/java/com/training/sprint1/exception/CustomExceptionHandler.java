package com.training.sprint1.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	 @ExceptionHandler(Exception.class)
	 public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	     List<String> details = new ArrayList<>();
	     details.add(ex.getLocalizedMessage());
	     ErrorResponse error = new ErrorResponse("Server Error", details);
	     return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
	 @ExceptionHandler(RecordNotFoundException.class)
	    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Record Not Found", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    } 
	 
	 @ExceptionHandler(UserNotFoundException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("User Not Found", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    } 
	    
	    @ExceptionHandler(AirportNotFoundException.class)
	    public final ResponseEntity<Object> handleAirportNotFoundException(AirportNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Airport Not Found", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(FlightNotFoundException.class)
	    public final ResponseEntity<Object> handleFlightNotFoundException(FlightNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Flight Not Found", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(RecordAlreadyPresentException.class)
	    public final ResponseEntity<Object> handleRecordAlreadyPresentException(RecordAlreadyPresentException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Record Already Present", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(BookingNotFoundException.class)
	    public final ResponseEntity<Object> handleBookingNotFoundException(BookingNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Booking Not Found", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
	
	
	
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
