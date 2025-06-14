package com.ezsoftware.ezplans.Model.DTO.VistaDetalladaPlan;

public record DatosResumenMiembrosPlan(
    Integer idMiembro,
    String nombre,
    String celular,
    String montoTotalDeuda,
    String aportacionTotal,
    Boolean tieneDeuda
) {}
