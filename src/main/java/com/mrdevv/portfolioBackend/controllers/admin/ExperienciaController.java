package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.services.IExperienciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("admin/experiencias")
public class ExperienciaController {

    private final IExperienciaService experienciaService;


}
