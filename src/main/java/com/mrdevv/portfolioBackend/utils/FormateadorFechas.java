package com.mrdevv.portfolioBackend.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormateadorFechas {

    public static String formatearDiaMesAnioHorayMinutos(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return localDateTime.format(formatter);
    }
}
