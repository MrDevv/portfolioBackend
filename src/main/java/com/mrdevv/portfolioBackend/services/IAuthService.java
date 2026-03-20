package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.request.AuthDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.models.Usuario;

import java.util.Optional;

public interface IAuthService {

    ResponseUsuarioLoginDTO login(AuthDTO authDTO);

}
