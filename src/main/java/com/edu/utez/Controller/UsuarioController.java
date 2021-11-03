package com.edu.utez.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.edu.utez.Entity.Usuario;
import com.edu.utez.Repository.UsuarioRepository;

@RestController
@RequestMapping("/uber")
@CrossOrigin(origins = "*",methods =
{RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
@PreAuthorize("isAuthenticated()")

public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("usuario/getUsuario/{email}")
	public Usuario getUsuario(@PathVariable("email") String email) {
		try {
			return usuarioRepository.findByEmail(email);
		}catch(Exception e) {
			System.out.println("get Usuario "+e);
			return null;
		}
	}
}
