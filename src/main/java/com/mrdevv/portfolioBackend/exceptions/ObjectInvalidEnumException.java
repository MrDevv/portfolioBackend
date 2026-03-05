package com.mrdevv.portfolioBackend.exceptions;

import lombok.Getter;

@Getter
public class ObjectInvalidEnumException extends RuntimeException {
    private String messageBack;
    private String messageFront;

    public ObjectInvalidEnumException(String menssageBack, String messageFront){
        this.messageBack = menssageBack;
        this.messageFront = messageFront;
    }
}
