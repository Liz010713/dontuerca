package com.taller.dontuerca.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;

    @Column(nullable = false, unique = true, length = 10)
    private String placa;

    private Integer anio;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Aquí iría también la relación con Modelo si ya creaste esa entidad
}