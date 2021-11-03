package com.edu.utez.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.utez.Entity.MiDetalleUsuario;
import com.edu.utez.Entity.Usuario;

import javax.transaction.Transactional;

@Service
@Transactional
public class MiDetalleUsuarioService implements UserDetailsService {

	@Autowired
	UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuarioX = usuarioService.getByEmail(username);
		if(usuarioX == null) {
			throw new UsernameNotFoundException("Usuario no Encontrado");
		}

		return MiDetalleUsuario.construir(usuarioX);
	}

}