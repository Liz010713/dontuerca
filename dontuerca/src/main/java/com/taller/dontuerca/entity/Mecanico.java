package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data @Entity @Table(name = "mecanicos")
public class Mecanico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idMecanico;
    @NotBlank @Column(nullable = false, length = 100) private String nombre;
    @Column(length = 100) private String especialidad;
}