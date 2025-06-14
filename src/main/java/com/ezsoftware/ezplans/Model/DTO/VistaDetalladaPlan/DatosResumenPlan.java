package com.ezsoftware.ezplans.Model.DTO.VistaDetalladaPlan;

import java.math.BigDecimal;

public record DatosResumenPlan(
        Integer idPlan,
        String titulo,
        String fecha,
        String estado,
        BigDecimal avance,
        String gastoTotal,
        String numeroDeMiembros,
        String actividadesCompletadas,
        Integer deudasPendientes
) {}
