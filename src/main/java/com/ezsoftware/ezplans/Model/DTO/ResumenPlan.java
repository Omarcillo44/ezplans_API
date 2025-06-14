package com.ezsoftware.ezplans.Model.DTO;

import java.math.BigDecimal;

public record ResumenPlan(
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
