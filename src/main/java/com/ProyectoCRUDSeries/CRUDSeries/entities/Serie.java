package com.ProyectoCRUDSeries.CRUDSeries.entities;

import com.ProyectoCRUDSeries.CRUDSeries.Config.AppConfig;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="series")
@ToString
public class Serie {

    @Id @Getter @Setter @Column(name="id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter @Setter @Column(name="Titulo")
    private String titulo;
    @Getter @Setter @Column(name="Descripcion")
    private String descripcion;
    @Getter @Setter @Column(name="Fecha de Estreno") @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate fechaDeEstreno;
    @Getter @Setter @Column(name="Estrellas")
    private Integer estrellas;
    @Getter @Setter @Column(name="Genero")
    private String genero;
    @Getter @Setter @Column(name="Precio")
    private Double precio;
    @Getter @Setter @Column(name="ATP")
    private Boolean atp;
    @Getter @Setter @Column(name="Estado")
    private String estado;

}
