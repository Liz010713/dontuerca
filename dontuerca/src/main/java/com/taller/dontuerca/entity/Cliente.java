package com.taller.dontuerca.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull(message = "El tipo de documento es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @NotBlank(message = "El número de documento no puede ir vacío")
    @Column(nullable = false, unique = true, length = 50)
    private String numeroDocumento;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;

    // --- MAGIA PARA TRAER LA INFORMACIÓN RELACIONADA ---

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("cliente") // Evita el error de recursividad infinita en Postman
    private List<Vehiculo> vehiculos;
}