package com.mrdevv.portfolioBackend.exceptions;

import lombok.Getter;

@Getter
public class ObjectReplicatedException extends RuntimeException {
    private String messageBack;
    private String messageFront;

    public ObjectReplicatedException(String menssageBack, String messageFront){
        this.messageBack = menssageBack;
        this.messageFront = messageFront;
    }
}
