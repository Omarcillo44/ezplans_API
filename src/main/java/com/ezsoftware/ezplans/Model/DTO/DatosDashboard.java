package com.ezsoftware.ezplans.Model.DTO;

import java.util.List;

public record DatosDashboard(
        DatosResumenPlanes resumenPlanes,
        List<DatosPlanesUsuarioDashboard> planesUsuario
) {
}
