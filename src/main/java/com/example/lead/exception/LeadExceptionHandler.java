package com.example.lead.exception;

import com.example.lead.constants.ErrorMessages;
import com.example.lead.dto.ErrorResponse;
import com.example.lead.dto.ExceptionHandlerResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class LeadExceptionHandler {
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionHandlerResponse constraintViolationException(ConstraintViolationException ex) {
        return new ExceptionHandlerResponse(HttpStatus.BAD_REQUEST.name(), new ErrorResponse("BRE001", Collections.singletonList(ex.getMessage())));
    }

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionHandlerResponse noHandlerFoundException(Exception ex) {
        return new ExceptionHandlerResponse("ResourceNotFoundException", new ErrorResponse("RNE001", Collections.singletonList(ex.getMessage())));
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionHandlerResponse unknownException(Exception ex) {
        return new ExceptionHandlerResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(), new ErrorResponse("ISE001", Collections.singletonList(ex.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionHandlerResponse handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return new ExceptionHandlerResponse(HttpStatus.BAD_REQUEST.name(), new ErrorResponse("BRE001", errors));
    }

    @ExceptionHandler(value = { BusinessValidationException.class })
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionHandlerResponse businessValidationException(BusinessValidationException ex) {
        return new ExceptionHandlerResponse(HttpStatus.UNPROCESSABLE_ENTITY.name(), new ErrorResponse("BVE001", Collections.singletonList(ex.getMessage())));
    }
}
