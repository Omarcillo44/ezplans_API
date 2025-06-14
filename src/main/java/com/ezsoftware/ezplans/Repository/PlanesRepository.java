package com.ezsoftware.ezplans.Repository;

import com.ezsoftware.ezplans.Model.DTO.Dashboard.DatosPlanesDashboard;
import com.ezsoftware.ezplans.Model.DTO.Dashboard.DatosResumenDashboard;
import com.ezsoftware.ezplans.Model.DTO.DatosActividadPlan;
import com.ezsoftware.ezplans.Model.DTO.DatosResumenMiembrosPlan;
import com.ezsoftware.ezplans.Model.DTO.DatosDeudasPorPlan;
import com.ezsoftware.ezplans.Model.DTO.ResumenPlan;
import com.ezsoftware.ezplans.Model.Entity.Planes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanesRepository extends JpaRepository<Planes, Integer> {

    @Query(value = "SELECT * FROM obtener_planes_usuario(:idUsuario, :soloCompletos, :esAdmin)", nativeQuery = true)
    List<DatosPlanesDashboard> obtenerPlanesPorUsuario(
            @Param("idUsuario") Integer idUsuario,
            @Param("soloCompletos") Boolean soloCompletos,
            @Param("esAdmin") Boolean esAdmin
    );

    @Query(value = "SELECT * FROM obtener_resumen_usuario(:idUsuario)", nativeQuery = true)
    DatosResumenDashboard obtenerResumenUsuario(
            @Param("idUsuario") Integer idUsuario
    );

    @Query(value = "SELECT * FROM obtener_resumen_plan(1)", nativeQuery = true)
    ResumenPlan obtenerResumenDePlan(@Param("idPlan") Integer idPlan);

    @Query(value = "SELECT * FROM obtener_actividades_por_plan(:idPlan)", nativeQuery = true)
    List<DatosActividadPlan> obtenerActividadesPorPlan(@Param("idPlan") Integer idPlan);

    @Query(value = "SELECT * FROM obtener_resumen_miembros_plan(:idPlan)", nativeQuery = true)
    List<DatosResumenMiembrosPlan> obtenerMiembrosDelPlan(@Param("idPlan") Integer idPlan);

    @Query(value = "SELECT * FROM obtener_deudas_por_plan(:idPlan)", nativeQuery = true)
    List<DatosDeudasPorPlan> obtenerDeudasPorPlan(@Param("idPlan") Integer idPlan);

}
