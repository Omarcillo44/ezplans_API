package com.ezsoftware.ezplans.Model.DTO;

public record DatosActividadPlan(
    int idActividad,
    String titulo,
    String montoTotal,
    String miembros,
    String estado
) {}
