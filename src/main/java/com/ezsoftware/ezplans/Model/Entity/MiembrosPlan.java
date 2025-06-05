package com.ezsoftware.ezplans.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "miembros_plan")
public class MiembrosPlan {
    @Id
    @ColumnDefault("nextval('miembros_plan_id_miembrosplan_seq')")
    @Column(name = "id_miembrosplan", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_plan", nullable = false)
    private Planes idPlan;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private com.ezsoftware.ezplans.Model.Entity.Usuario idUsuario;

    @Column(name = "administrador", nullable = false)
    private Boolean administrador = false;

}