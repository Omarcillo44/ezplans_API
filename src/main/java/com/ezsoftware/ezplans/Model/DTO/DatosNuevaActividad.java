package com.ezsoftware.ezplans.Model.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DatosNuevaActividad(
        Integer idPlan,
        String titulo,
        BigDecimal montoTotal,
        String detalles
) {}
