package com.ezsoftware.ezplans.Repository;

import com.ezsoftware.ezplans.Model.Entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface PagosRepository extends JpaRepository<Pago, Integer> {
    @Query(value = "SELECT insertar_pago(:idDeuda, :montoPago, :formaPago, :comprobantePago)", nativeQuery = true)
    void insertarPago(
            @Param("idDeuda") Integer idDeuda,
            @Param("montoPago") BigDecimal montoPago,
            @Param("formaPago") Boolean formaPago,
            @Param("comprobantePago") String comprobantePago
    );
}
