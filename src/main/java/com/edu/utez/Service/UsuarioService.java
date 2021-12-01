package com.edu.utez.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edu.utez.Entity.Rol;
import com.edu.utez.Entity.Usuario;
import com.edu.utez.Repository.RoleRepository;
import com.edu.utez.Repository.UsuarioRepository;
import com.edu.utez.enums.RolNombre;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Usuario getByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	public boolean existsByNickname(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	public boolean save(Usuario usuario, RolNombre autoridad) {
		Usuario us = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(us == null) {
			System.out.println(usuario);
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			
			Rol rol = roleRepository.findByRolNombre(autoridad);
			List<Rol> roles = new ArrayList<>();
			roles.add(rol);
			usuario.setRoles(roles);
			
			return usuarioRepository.existsById(usuarioRepository.save(usuario).getIdUsuario());
		
		}else{
			return usuarioRepository.existsById(usuarioRepository.save(usuario).getIdUsuario());
		}
	}
	
	public boolean deleteUser(int id) {
		usuarioRepository.deleteById(id);
		return !usuarioRepository.existsById(id);
	}

	public List<Usuario> filtroUsuario(){
		try {
			List<Usuario> listaAux = usuarioRepository.findbyFiltro();
			List<Usuario> lista = new ArrayList<>();
			
			for(int i = 0; i<listaAux.size(); i++) {
				if(listaAux.get(i).isLogeado() && listaAux.get(i).getToken() != null) {
					lista.add(listaAux.get(i));
				}
			}
			
			return lista;
			
		}catch (Exception e){
			System.out.println("Error en filtro usuarios"+e);
			return null;
		}
	}
}
