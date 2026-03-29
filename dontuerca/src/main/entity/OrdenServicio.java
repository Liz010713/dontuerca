package com.taller.dontuerca.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ordenes_servicio")
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrden;

    @Column(name = "fecha_ingreso", insertable = false, updatable = false)
    private LocalDateTime fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    // Asumiendo que crearás las entidades Mecanico, Servicio y EstadoOrden luego:
    @Column(name = "id_mecanico")
    private Integer idMecanico;
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Column(name = "id_estado_orden")
    private Integer idEstadoOrden;
}