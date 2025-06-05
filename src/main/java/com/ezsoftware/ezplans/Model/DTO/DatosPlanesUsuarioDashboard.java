package com.ezsoftware.ezplans.Model.DTO;

public record DatosPlanesUsuarioDashboard(
        String titulo,
        String fecha,
        String gastoTotal,
        String numeroDeMiembros,
        String rolDelUsuario,
        String estadoDelPlan
) { }
