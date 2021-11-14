package com.edu.utez.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.utez.Entity.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	Usuario findByIdUsuario(int idUsuario);

	@Query(value = "SELECT * from usuario where (logeado = true); ", nativeQuery = true)
	List<Usuario> findbyFiltro ();

}
