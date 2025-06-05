package com.ezsoftware.ezplans.Controller;

import com.ezsoftware.ezplans.Model.DTO.DatosPlanesUsuarioDashboard;
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

    @GetMapping
    public ResponseEntity<List<DatosPlanesUsuarioDashboard>> obtenerPlanesUsuario(
            @RequestParam Integer idUsuario,
            @RequestParam(required = false) Boolean soloCompletos,
            @RequestParam(required = false) Boolean esAdmin
    ) {
        var planes = planesRepository.obtenerPlanesPorUsuario(idUsuario, soloCompletos, esAdmin);
        return ResponseEntity.ok(planes);
    }
}
