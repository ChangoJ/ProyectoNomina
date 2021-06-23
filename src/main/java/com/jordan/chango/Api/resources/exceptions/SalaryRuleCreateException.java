package com.jordan.chango.Api.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SalaryRuleCreateException extends Exception{
    private static final long serialVersionUID = -7717691994704695707L;

    public SalaryRuleCreateException(String message){
        super(message);
    }
}