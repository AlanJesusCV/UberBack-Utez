package com.edu.utez.Service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utez.Entity.Viaje;
import com.edu.utez.Repository.UsuarioRepository;
import com.edu.utez.Repository.ViajeRepository;

@Service
@Transactional
public class ViajeService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ViajeRepository viajeRepository;
	
	public List<Viaje> getViajeUsuario(int id) {
		try {
			return viajeRepository.findByClienteIdUsuario(id);
		}catch (Exception e) {
			System.out.println("Consulta viaje por cliente "+e);
			return null;
		}
	}
	
	public Viaje getViaje(int id) {
		try {
			return viajeRepository.findByIdViaje(id);
		}catch(Exception e){
			System.out.println("Consulta viaje "+e);
			return null;
		}
	}
	
	public boolean saveViaje(Viaje viaje) {
		try {
			
			Date fechaAux = new Date();
			@SuppressWarnings("deprecation")
			String fecha = fechaAux.getDay()+"/"+fechaAux.getMonth()+"/"+fechaAux.getYear();
			
		    @SuppressWarnings("deprecation")
			String hora = fechaAux.getHours()+"/"+fechaAux.getMinutes();
		    
		    if(viaje.getEstatus() == "Aceptado") {
		    	viaje.setFechaViaje(fecha);
		    	viaje.setHoraInicio(hora);
		    }
			return viajeRepository.existsById(viajeRepository.save(viaje).getIdViaje());
		}catch(Exception e) {
			System.out.println("Registro de viaje "+e);
			return false;
		}
	}
	
	public boolean eliminarViaje(int id) {
		try {
			viajeRepository.deleteById(id);
			return !viajeRepository.existsById(id);
		}catch(Exception e) {
			System.out.println("Eliminacion de viaje "+e);
			return false;
		}
	}
	
	
}
