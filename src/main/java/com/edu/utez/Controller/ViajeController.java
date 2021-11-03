package com.edu.utez.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.utez.Entity.Viaje;
import com.edu.utez.Service.UsuarioService;
import com.edu.utez.Service.ViajeService;

@RestController
@RequestMapping("/uber")
@CrossOrigin(origins = "*",methods =
        {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")

public class ViajeController {

	@Autowired
	ViajeService viajeService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/viaje/getViajesCliente/{id}")
	public List<Viaje> getViajesCliente(@PathVariable("id") int id){
		return viajeService.getViajeUsuario(id);
	}
	
	@GetMapping("/viaje/getViaje/{id}")
	public Viaje getViaje(@PathVariable("id") int id) {
		return viajeService.getViaje(id);
	}
	
	@PostMapping("/viaje/saveViaje")
	public boolean saveViaje(@RequestBody Viaje viaje) {
		return viajeService.saveViaje(viaje);
	}
	
	@DeleteMapping("/viaje/deleteViaje/{id}")
	public boolean deleteViaje(@PathVariable("id") int id) {
		return viajeService.eliminarViaje(id);
	}
	
	
}
