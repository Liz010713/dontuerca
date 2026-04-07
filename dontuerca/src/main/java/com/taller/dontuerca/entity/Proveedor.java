package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data @Entity @Table(name = "proveedores")
public class Proveedor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idProveedor;
    @NotBlank @Column(nullable = false, length = 100) private String nombreEmpresa;
    @Column(length = 20) private String telefono;
}