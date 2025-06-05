package com.ezsoftware.ezplans.Controller;

import com.ezsoftware.ezplans.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/prueba")
public class ControladorPrueba {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<?> obtenerUsuario(@RequestParam Integer id) {
        var usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(
                    Map.of(
                            "id", usuario.get().getId(),
                            "celularUsuario", usuario.get().getCelularUsuario(),
                            "nombre", usuario.get().getNombreUsuario(),
                            "apellido", usuario.get().getApellidosUsuario()
                            )
            );
        }
        return ResponseEntity.notFound().build();
    }
}
