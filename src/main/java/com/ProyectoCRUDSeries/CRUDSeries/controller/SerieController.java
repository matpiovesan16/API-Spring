package com.ProyectoCRUDSeries.CRUDSeries.controller;

import com.ProyectoCRUDSeries.CRUDSeries.entities.Serie;
import com.ProyectoCRUDSeries.CRUDSeries.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/series")
public class SerieController{
    @Autowired
    private SerieService serieService;

    @GetMapping()
    public String listarSeries(Model model){
        List <Serie> series = serieService.obtenerSerie();
        model.addAttribute("serieLista", series);
        return "tabla";

    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaSerie(Model model){
        model.addAttribute("serie", new Serie ());
        model.addAttribute("action", "/series/nueva");
        return "formularioSerieNueva";
    }

    @PostMapping("/nueva")
    public String guardarNuevaSerie(@ModelAttribute Serie serie){
        serieService.crearSerie(serie);
        return "redirect:/series";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarSerie(@PathVariable Long id){
        serieService.eliminarSerie(id);
        return "redirect:/series";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarserie(@PathVariable Long id, Serie serie,Model model){

        serie = serieService.obtenerPorId(id);
        String estado = serie.getEstado();

        if(!Objects.equals(estado, "AN")){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
            String fechaFormateada = serie.getFechaDeEstreno().format(formatter);

            model.addAttribute("serie", serie);
            model.addAttribute("fechaFormateada", fechaFormateada);
            model.addAttribute("action", "/series/editar/" + id);
            return "formularioEdicionSerie";
        }
        return "redirect:/series";




    }

    @PostMapping("/editar/{id}")
    public String guardarSerieEditada(@PathVariable Long id, @ModelAttribute Serie serie){
        serieService.actualizarSerie(id,serie);
        return "redirect:/series";
    }

    @GetMapping("/estado/{id}")
    public String cambiarEstadoSerie(@PathVariable Long id){
        Serie serie = serieService.obtenerPorId(id);
        if(Objects.equals(serie.getEstado(), "AN")){
            return null;
        }
        serie.setEstado("AN");
        serieService.actualizarSerie(id, serie);

        return "redirect:/series";
    }




}
