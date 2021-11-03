package com.edu.utez.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.utez.Entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	Usuario findByIdUsuario(int idUsuario);

}
