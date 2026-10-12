package com.mrdevv.portfolioBackend.exceptions;

import lombok.Getter;

@Getter
public class PasswordNotMatchException extends RuntimeException {
    private String messageBack;
    private String messageFront;

    public PasswordNotMatchException(String messageBack, String messageFront){
        this.messageBack = messageBack;
        this.messageFront = messageFront;
    }
}
