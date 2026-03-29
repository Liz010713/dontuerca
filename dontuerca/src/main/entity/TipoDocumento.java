package com.taller.dontuerca.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // Magia de Lombok: crea getters, setters, toString, etc. automáticamente
@Entity
@Table(name = "tipos_documento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoDocumento;

    @Column(nullable = false, length = 10)
    private String sigla;

    @Column(nullable = false, length = 50)
    private String descripcion;
}