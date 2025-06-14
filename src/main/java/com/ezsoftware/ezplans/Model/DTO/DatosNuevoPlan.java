package com.ezsoftware.ezplans.Model.DTO;

import java.time.LocalDate;
import java.util.List;

public record DatosNuevoPlan(
    String titulo,
    LocalDate fechaPlan,
    String detallesPlan,
    List<DatosMiembrosNuevoPlan> miembros
) {}


