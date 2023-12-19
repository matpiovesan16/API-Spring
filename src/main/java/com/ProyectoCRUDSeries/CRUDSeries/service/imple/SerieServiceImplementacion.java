package com.ProyectoCRUDSeries.CRUDSeries.service.imple;

import com.ProyectoCRUDSeries.CRUDSeries.entities.Serie;
import com.ProyectoCRUDSeries.CRUDSeries.repository.SerieRepository;
import com.ProyectoCRUDSeries.CRUDSeries.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SerieServiceImplementacion implements SerieService {

    @Autowired
    private SerieRepository serieRepository;
    @Override
    public List<Serie> obtenerSerie() { return serieRepository.findAll();}

    @Override
    public Serie obtenerPorId(Long id) { return serieRepository.findById(id).orElse(null);}

    @Override
    public Serie crearSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public Serie actualizarSerie(Long id, Serie serie) {
        Serie serieActualizar = serieRepository.findById(id).orElse(null);
        if(serieActualizar != null){
            serieActualizar.setTitulo(serie.getTitulo());
            serieActualizar.setDescripcion(serie.getDescripcion());
            serieActualizar.setFechaDeEstreno(serie.getFechaDeEstreno());
            serieActualizar.setEstrellas(serie.getEstrellas());
            serieActualizar.setGenero(serie.getGenero());
            serieActualizar.setPrecio(serie.getPrecio());
            serieActualizar.setAtp(serie.getAtp());
            serieActualizar.setEstado(serie.getEstado());

            return serieRepository.save(serieActualizar);
        }
        return null;
    }

    @Override
    public void eliminarSerie(Long id) {
        serieRepository.deleteById(id);

    }
}
