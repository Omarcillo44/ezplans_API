package com.ezsoftware.ezplans.Model.DTO.VistaDetalladaPlan;

public record DatosActividadPlan(
    int idActividad,
    String titulo,
    String montoTotal,
    String miembros,
    String estado
) {}
