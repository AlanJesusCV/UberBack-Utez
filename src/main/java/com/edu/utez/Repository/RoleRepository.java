package com.edu.utez.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utez.Entity.Rol;
import com.edu.utez.enums.RolNombre;

public interface RoleRepository extends JpaRepository<Rol, Integer> {
	Rol findByRolNombre(RolNombre rolNombre);

}
