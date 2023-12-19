package com.ProyectoCRUDSeries.CRUDSeries.service;

import com.ProyectoCRUDSeries.CRUDSeries.entities.Serie;

import java.util.List;

public interface SerieService {

    List<Serie> obtenerSerie ();
    Serie obtenerPorId(Long id);
    Serie crearSerie(Serie serie);
    Serie actualizarSerie(Long id, Serie serie);

    void eliminarSerie(Long id);
}
