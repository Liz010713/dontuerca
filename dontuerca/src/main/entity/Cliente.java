package com.taller.dontuerca.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    // Aquí está la relación (La Llave Foránea)
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "numero_documento", nullable = false, unique = true, length = 50)
    private String numeroDocumento;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;
}