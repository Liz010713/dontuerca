package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity @Table(name = "modelos")
public class Modelo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idModelo;
    @NotNull @ManyToOne @JoinColumn(name = "id_marca", nullable = false) private Marca marca;
    @NotBlank @Column(nullable = false, length = 50) private String nombreModelo;
}