package com.mrdevv.portfolioBackend.services.mail;

public interface IMailService {

    void enviarCorreoConfirmacionCuenta(String token, String destinatario);

}
