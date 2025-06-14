package com.ezsoftware.ezplans.Controller;

import com.ezsoftware.ezplans.Model.DTO.*;
import com.ezsoftware.ezplans.Repository.PlanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class ControladorPlanes {

    @Autowired
    private PlanesRepository planesRepository;

    public static record VistaDetalladaPlan(
            ResumenPlan resumenPlan,
            List<DatosActividadPlan> actividades,
            List<DatosResumenMiembrosPlan> miembros,
            List<DatosDeudasPorPlan> deudas
    ) {}

    @GetMapping("/vista_detallada")
    public ResponseEntity<List<DatosActividadPlan>> obtenerVistaDetallada(@RequestParam Integer idPlan) {
        List<DatosActividadPlan> resumen = planesRepository.obtenerActividadesPorPlan(idPlan);

        return ResponseEntity.ok(resumen);
    }
}
