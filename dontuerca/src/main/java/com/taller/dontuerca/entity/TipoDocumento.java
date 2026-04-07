package com.taller.dontuerca.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data @Entity @Table(name = "tipos_documento")
public class TipoDocumento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idTipoDocumento;
    @NotBlank(message = "La sigla es obligatoria") @Column(nullable = false, length = 10) private String sigla;
    @NotBlank(message = "La descripción es obligatoria") @Column(nullable = false, length = 50) private String descripcion;
}