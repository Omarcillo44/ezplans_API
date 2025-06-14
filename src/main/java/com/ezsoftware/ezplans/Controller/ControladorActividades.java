package com.ezsoftware.ezplans.Controller;

import com.ezsoftware.ezplans.Model.DTO.DatosNuevaActividad;
import com.ezsoftware.ezplans.Model.DTO.DatosNuevoPlan;
import com.ezsoftware.ezplans.Model.DTO.VistaDetalladaPlan.*;
import com.ezsoftware.ezplans.Model.Entity.Actividad;
import com.ezsoftware.ezplans.Model.Entity.Plan;
import com.ezsoftware.ezplans.Repository.ActividadesRepository;
import com.ezsoftware.ezplans.Repository.PlanesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ControladorActividades {

    @Autowired
    private PlanesRepository planesRepository;

    @Autowired
    private ActividadesRepository actividadesRepository;

    @Transactional
    @PostMapping("/nueva_actividad")
    public ResponseEntity<String> crearActividad(@RequestBody DatosNuevaActividad datos) {
        try {
            Plan plan = planesRepository.findById(datos.idPlan())
                    .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

            Actividad nuevaActividad = new Actividad();
            nuevaActividad.setIdPlan(plan);
            nuevaActividad.setTituloActividad(datos.titulo());
            nuevaActividad.setGastoActividad(datos.montoTotal());
            nuevaActividad.setDetallesActividad(datos.detalles());
            nuevaActividad.setEstadoActividad(false); // o true si quieres activarla por defecto

            actividadesRepository.save(nuevaActividad);

            return ResponseEntity.ok("Actividad creada con ID: " + nuevaActividad.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la actividad: " + e.getMessage());
        }
    }

}
