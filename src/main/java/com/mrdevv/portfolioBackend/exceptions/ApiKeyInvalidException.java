package com.mrdevv.portfolioBackend.exceptions;

import lombok.Getter;

@Getter
public class ApiKeyInvalidException extends RuntimeException {
    private String messageBack;
    private String messageFront;

    public ApiKeyInvalidException(String menssageBack, String messageFront){
        this.messageBack = menssageBack;
        this.messageFront = messageFront;
    }
}
