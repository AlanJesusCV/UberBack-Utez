package com.edu.utez.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.utez.Entity.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
	
	Viaje findByIdViaje (int id);
	
	List<Viaje> findByClienteIdUsuario (int id);
}
