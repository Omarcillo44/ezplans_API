package com.ezsoftware.ezplans.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "planes")
public class Planes {
    @Id
    @ColumnDefault("nextval('planes_id_plan_seq')")
    @Column(name = "id_plan", nullable = false)
    private Integer id;

    @Column(name = "titulo_plan", nullable = false, length = Integer.MAX_VALUE)
    private String tituloPlan;

    @Column(name = "fecha_plan", nullable = false)
    private LocalDate fechaPlan;

    @Column(name = "gasto_plan")
    private BigDecimal gastoPlan;

    @Column(name = "detalles_plan", length = Integer.MAX_VALUE)
    private String detallesPlan;

    @Column(name = "estado_plan")
    private Boolean estadoPlan;

}