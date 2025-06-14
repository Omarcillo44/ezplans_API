package com.ezsoftware.ezplans.Model.DTO.VistaDetalladaPlan;

public record DatosDeudasPorPlan(
    Integer idDeuda,
    String deudor,
    String acreedor,
    String actividad,
    String montoFormateado
) {}
