package com.ezsoftware.ezplans.Controller;

import com.ezsoftware.ezplans.Model.DTO.DatosNuevoPlan;
import com.ezsoftware.ezplans.Model.DTO.DatosMiembrosNuevoPlan;
import com.ezsoftware.ezplans.Model.DTO.VistaDetalladaPlan.*;
import com.ezsoftware.ezplans.Model.Entity.MiembrosPlan;
import com.ezsoftware.ezplans.Model.Entity.Plan;
import com.ezsoftware.ezplans.Model.Entity.Usuario;
import com.ezsoftware.ezplans.Repository.ActividadesRepository;
import com.ezsoftware.ezplans.Repository.MiembrosPlanRepository;
import com.ezsoftware.ezplans.Repository.PlanesRepository;
import com.ezsoftware.ezplans.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/planes")
public class ControladorPlanes {

    @Autowired
    private PlanesRepository planesRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MiembrosPlanRepository miembrosPlanRepository;

    @Transactional
    @PostMapping("/nuevo_plan")
    public ResponseEntity<String> nuevoPlan(@RequestBody DatosNuevoPlan planRequest) {

        /*Primero crea la nueva entidad Plan*/
        Plan nuevoPlan = new Plan();
        nuevoPlan.setTituloPlan(planRequest.titulo());
        nuevoPlan.setFechaPlan(planRequest.fechaPlan());
        nuevoPlan.setDetallesPlan(planRequest.detallesPlan());
        nuevoPlan.setEstadoPlan(false);
        nuevoPlan.setGastoPlan(BigDecimal.ZERO);

        try {
            //Guardamos la entidad dentro de la BD
            planesRepository.save(nuevoPlan);

            for (DatosMiembrosNuevoPlan nuevoMiembro : planRequest.miembros()) {
                //Se crea la entidad para almacenar los usuarios relacionados al plan (Muchos a 1)
                MiembrosPlan miembrosDeNUevoPlan = new MiembrosPlan();
                miembrosDeNUevoPlan.setIdPlan(nuevoPlan);

                //Buscamos al usuario dentro de la BD
                Usuario usuario = usuarioRepository.findById(nuevoMiembro.idUsuario())
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + nuevoMiembro.idUsuario()));
                miembrosDeNUevoPlan.setIdUsuario(usuario); //Usuario encontrado, se añade a la entidad

                //Se añade el admin, sólo si tiene true en su atributo de admin
                miembrosDeNUevoPlan.setAdministrador(nuevoMiembro.administrador());

                //Salvamos al usuario dentro de la tabla en la BD
                miembrosPlanRepository.save(miembrosDeNUevoPlan);
            }
            return ResponseEntity.ok("Plan creado con ID: " + nuevoPlan.getId());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el plan: " + e.getMessage());
        }
    }



    @GetMapping("/vista_detallada")
    public ResponseEntity<DatosVistaDetalladaPlan> obtenVistaDetalladaDePlan(@RequestParam Integer idPlan) {
        DatosResumenPlan resumenPlan = planesRepository.obtenResumenPorPlan(idPlan);
        List<DatosActividadPlan> resumenActividadesPlan = planesRepository.obtenResumenActividadesPorPlan(idPlan);
        List<DatosResumenMiembrosPlan> resumenMiembrosPlan = planesRepository.obtenResumenPorMiembrosDelPlan(idPlan);
        List<DatosDeudasPorPlan> resumenDeudasPlan = planesRepository.obtenResumenDeudasPorPlan(idPlan);

        DatosVistaDetalladaPlan vistaDetallada = new DatosVistaDetalladaPlan
                (
                resumenPlan, resumenActividadesPlan, resumenMiembrosPlan, resumenDeudasPlan
                );

        return ResponseEntity.ok(vistaDetallada);
    }
}
