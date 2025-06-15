package com.ezsoftware.ezplans.Model.DTO.VistaDetalladaPlan;

public record DatosDeudasPorPlan(
    Integer idDeuda,
    String nombreDeudor,
    String nombreAcreedor,
    String tituloActividad,
    String montoDeuda
) {}
