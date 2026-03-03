package com.mrdevv.portfolioBackend.utils;

public enum TipoResponse {
    CREATE(201),
    GET(200),
    GETALL(200),
    UPDATE(200),
    DELETE(200),
    PATCH(200);

    private int status;

    TipoResponse(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
