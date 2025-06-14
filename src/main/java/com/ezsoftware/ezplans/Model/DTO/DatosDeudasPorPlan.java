package com.ezsoftware.ezplans.Model.DTO;

public record DatosDeudasPorPlan(
    Integer idDeuda,
    String deudor,
    String acreedor,
    String actividad,
    String montoFormateado
) {}
