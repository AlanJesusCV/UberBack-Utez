package com.edu.utez.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.utez.Entity.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {

    Calificacion findCalificacionByIdCalificacion(int id);

}
