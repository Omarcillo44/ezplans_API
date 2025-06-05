package com.ezsoftware.ezplans.Repository;

import com.ezsoftware.ezplans.Model.DTO.DatosPlanesUsuarioDashboard;
import com.ezsoftware.ezplans.Model.Entity.Planes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface PlanesRepository extends JpaRepository<Planes, Integer> {

    @Query(value = "SELECT * FROM obtener_planes_usuario(:idUsuario, :soloCompletos, :esAdmin)", nativeQuery = true)
    List<DatosPlanesUsuarioDashboard> obtenerPlanesPorUsuario(
            @Param("idUsuario") Integer idUsuario,
            @Param("soloCompletos") Boolean soloCompletos,
            @Param("esAdmin") Boolean esAdmin
    );


}
