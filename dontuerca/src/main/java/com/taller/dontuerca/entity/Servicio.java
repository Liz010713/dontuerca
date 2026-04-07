package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data @Entity @Table(name = "servicios")
public class Servicio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idServicio;
    @NotBlank @Column(nullable = false, length = 100) private String nombreServicio;
    @NotNull @Column(nullable = false) private BigDecimal costoManoObra;
}