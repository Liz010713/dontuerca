package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data @Entity @Table(name = "categorias_repuesto")
public class CategoriaRepuesto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idCategoria;
    @NotBlank @Column(nullable = false, length = 50) private String nombreCategoria;
}