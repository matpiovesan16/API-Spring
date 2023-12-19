package com.ProyectoCRUDSeries.CRUDSeries.repository;

import com.ProyectoCRUDSeries.CRUDSeries.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SerieRepository extends JpaRepository <Serie, Long> {
}
