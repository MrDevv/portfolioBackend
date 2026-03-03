package com.mrdevv.portfolioBackend.exceptions;

import lombok.Getter;

@Getter
public class ObjectNotFoundException extends RuntimeException {

    private String messageBack;
    private String messageFront;

    public ObjectNotFoundException(String menssageBack, String messageFront){
        this.messageBack = menssageBack;
        this.messageFront = messageFront;
    }
}
