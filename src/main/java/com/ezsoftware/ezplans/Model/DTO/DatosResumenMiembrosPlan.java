package com.ezsoftware.ezplans.Model.DTO;

public record DatosResumenMiembrosPlan(
    Integer idMiembro,
    String nombre,
    String celular,
    String montoTotalDeuda,
    String aportacionTotal,
    Boolean tieneDeuda
) {}
