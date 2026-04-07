package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data @Entity @Table(name = "estados_orden")
public class EstadoOrden {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idEstadoOrden;
    @NotBlank @Column(nullable = false, unique = true, length = 50) private String nombreEstado;
}