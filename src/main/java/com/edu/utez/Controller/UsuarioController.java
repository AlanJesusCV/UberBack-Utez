package com.edu.utez.Controller;


import com.edu.utez.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.edu.utez.Entity.Usuario;
import com.edu.utez.Repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/uber")
@CrossOrigin(origins = "*",methods =
{RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
@PreAuthorize("isAuthenticated()")

public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("usuario/getUsuario/{email}")
	public Usuario getUsuario(@PathVariable("email") String email) {
		try {
			Usuario userAux = usuarioRepository.findByEmail(email);
			 userAux.setRoles(null);
			 return userAux;
			}catch(Exception e) {
			System.out.println("get Usuario "+e);
			return null;
		}
	}

	@GetMapping("usuario/getFiltroUsuario")
	public List<Usuario> filtroUsuario(){
		try {
			return usuarioService.filtroUsuario();
		} catch (Exception e){
			System.out.println("Erorr controller filtro");
			return null;
		}
	}
}
