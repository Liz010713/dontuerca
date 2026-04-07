package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data @Entity @Table(name = "ordenes_servicio")
public class OrdenServicio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idOrden;
    @Column(name = "fecha_ingreso", insertable = false, updatable = false) private LocalDateTime fechaIngreso;
    @NotNull @ManyToOne @JoinColumn(name = "id_vehiculo", nullable = false) private Vehiculo vehiculo;
    @NotNull @ManyToOne @JoinColumn(name = "id_mecanico", nullable = false) private Mecanico mecanico;
    @NotNull @ManyToOne @JoinColumn(name = "id_servicio", nullable = false) private Servicio servicio;
    @NotNull @ManyToOne @JoinColumn(name = "id_estado_orden", nullable = false) private EstadoOrden estadoOrden;
}