package com.ezsoftware.ezplans.Model.DTO.VistaDetalladaPlan;

import java.math.BigDecimal;

public record DatosResumenPlan(
        Integer idPlan,
        String tituloPlan,
        String fechaPlan,
        String estadoPlan,
        BigDecimal avancePlan,
        String gastoPlan,
        String cantidadMiembrosPlan,
        String actividadesCompletadasPlan,
        Integer cantidadDeudasPendientesPlan
) {}
