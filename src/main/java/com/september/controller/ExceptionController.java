package com.september.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Return and choose any page.")

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public void handleEmptyResultDataAccessException(){
        LOGGER.error("There is not name in the DB");
    }

}
