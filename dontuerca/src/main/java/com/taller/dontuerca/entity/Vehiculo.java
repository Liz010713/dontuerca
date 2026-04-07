package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity @Table(name = "vehiculos")
public class Vehiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idVehiculo;
    @NotBlank @Column(nullable = false, unique = true, length = 10) private String placa;
    @NotNull @ManyToOne @JoinColumn(name = "id_modelo", nullable = false) private Modelo modelo;
    private Integer anio;
    @NotNull @ManyToOne @JoinColumn(name = "id_cliente", nullable = false) private Cliente cliente;
}