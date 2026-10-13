package com.mrdevv.portfolioBackend.exceptions;

import lombok.Getter;

@Getter
public class ExpiredTokenUsuario extends RuntimeException {
    private String messageBack;
    private String messageFront;

    public ExpiredTokenUsuario(String menssageBack, String messageFront){
        this.messageBack = menssageBack;
        this.messageFront = messageFront;
    }
}
