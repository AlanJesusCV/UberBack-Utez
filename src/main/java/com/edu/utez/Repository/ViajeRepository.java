package com.edu.utez.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.utez.Entity.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
	
	Viaje findByIdViaje (int id);
	
	List<Viaje> findByClienteIdUsuario (int id);
	
	@Query(value ="SELECT * FROM uber_utez.viaje where (cliente_id_usuario = :id)  order by id_viaje DESC limit 1;", nativeQuery = true)
	Viaje findByClienteUltimo(@Param("id") int id);
	
	

}
