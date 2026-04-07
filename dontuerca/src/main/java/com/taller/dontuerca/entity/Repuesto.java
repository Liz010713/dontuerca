package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data @Entity @Table(name = "repuestos")
public class Repuesto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idRepuesto;
    @NotBlank @Column(nullable = false, length = 100) private String nombre;
    @NotNull @Column(nullable = false) private Integer stock;
    @NotNull @Column(nullable = false) private BigDecimal precioUnitario;
    @NotNull @ManyToOne @JoinColumn(name = "id_proveedor", nullable = false) private Proveedor proveedor;
    @NotNull @ManyToOne @JoinColumn(name = "id_categoria", nullable = false) private CategoriaRepuesto categoria;
}