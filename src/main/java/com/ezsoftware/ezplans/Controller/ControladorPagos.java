package com.ezsoftware.ezplans.Controller;

import com.ezsoftware.ezplans.Model.DTO.Pagos.DatosNuevoPago;
import com.ezsoftware.ezplans.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/pagos")
public class ControladorPagos {

    @Autowired
    private PagosRepository repositorioPagos;

    @PostMapping("/nuevo_pago")
    public ResponseEntity<String> registrarPago(@RequestBody DatosNuevoPago datos) {
        repositorioPagos.insertarPago(
                datos.idDeuda(),
                datos.montoPago(),
                datos.formaPago(),
                datos.comprobantePago()
        );
        return ResponseEntity.ok("Pago registrado con éxito");
    }
}
