package com.mrdevv.portfolioBackend.exceptions;

import lombok.Getter;

@Getter
public class AccountNotEnabledException extends RuntimeException {
    private String name;
    private String typeError;

    public AccountNotEnabledException(String name, String typeError){
        this.name = name;
        this.typeError = typeError;
    }
}
