package com.E_CommercePortal.Exception;

import com.E_CommercePortal.Payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class HandelException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handelException(Exception e, WebRequest request){
        ErrorDetails err=new ErrorDetails(e.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>( err,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
