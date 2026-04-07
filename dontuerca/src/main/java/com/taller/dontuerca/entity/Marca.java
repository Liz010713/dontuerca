package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data @Entity @Table(name = "marcas")
public class Marca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idMarca;
    @NotBlank @Column(nullable = false, unique = true, length = 50) private String nombreMarca;
}