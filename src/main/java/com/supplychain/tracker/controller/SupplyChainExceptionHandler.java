package com.supplychain.tracker.controller;

import com.google.gson.Gson;
import com.supplychain.tracker.model.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SupplyChainExceptionHandler {

    @Autowired
    Gson gson;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAllExceptons(Exception e) {
        ErrorModel err = new ErrorModel("encountered unexpected error", e.getMessage());
        return gson.toJson(err, ErrorModel.class);
    }

}


