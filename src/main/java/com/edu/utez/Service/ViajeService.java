package com.edu.utez.Service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utez.Entity.DetallesViaje;
import com.edu.utez.Entity.Usuario;
import com.edu.utez.Entity.Viaje;
import com.edu.utez.Entity.ViajeAux;
import com.edu.utez.Repository.UsuarioRepository;
import com.edu.utez.Repository.ViajeRepository;

@Service
@Transactional
public class ViajeService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ViajeRepository viajeRepository;
	
	public List<DetallesViaje> getViajeUsuario(int id) {
		try {
			
			 
			 List<Viaje> listaViaje = viajeRepository.findByClienteIdUsuario(id);
			 List<DetallesViaje> listaAux  = new ArrayList<>();
			 for(int i = 0; i<= listaViaje.size()-1; i++  ) {

				 DetallesViaje detalle = new DetallesViaje();
				 if(listaViaje.get(i).getTaxista() != null) {
					 detalle.setChofer(listaViaje.get(i).getTaxista().getNombre());
					 detalle.setColor(listaViaje.get(i).getTaxista().getColor_auto());
					 detalle.setPlacas(listaViaje.get(i).getTaxista().getPlacas());
					 detalle.setModelo(listaViaje.get(i).getTaxista().getModelo_auto());
				 }
				 detalle.setEstatus(listaViaje.get(i).getEstatus());
				 detalle.setCosto(listaViaje.get(i).getCosto());
				 detalle.setUbicacion(listaViaje.get(i).getUbicacion());
				 detalle.setDestino(listaViaje.get(i).getDestino());
				 detalle.setIdViaje(listaViaje.get(i).getIdViaje());
				 	
				 listaAux.add(detalle);
			 }
			 
			 return listaAux;
			 
		}catch (Exception e) {
			System.out.println("Consulta viaje por cliente "+e);
			return null;
		}
	}
	
	public DetallesViaje getViaje(int id) {
		try {
			Viaje viajeAux =  viajeRepository.findByClienteUltimo(id);
			DetallesViaje detalle = new DetallesViaje();
			if(viajeAux.getTaxista() != null) {
				 detalle.setChofer(viajeAux.getTaxista().getNombre());
				 detalle.setColor(viajeAux.getTaxista().getColor_auto());
				 detalle.setPlacas(viajeAux.getTaxista().getPlacas());
				 detalle.setModelo(viajeAux.getTaxista().getModelo_auto());
			}
			 detalle.setEstatus(viajeAux.getEstatus());
			 detalle.setCosto(viajeAux.getCosto());
			 detalle.setUbicacion(viajeAux.getUbicacion());
			 detalle.setDestino(viajeAux.getDestino());
			 detalle.setIdViaje(viajeAux.getIdViaje());
			 return detalle;
			
		}catch(Exception e){
			System.out.println("Consulta viaje "+e);
			return null;
		}
	}
	
	public ViajeAux saveViaje(ViajeAux viajeApi) {
		try {
			
			System.out.println(viajeApi.getIdViaje());
			Viaje viaje = new Viaje();
			Usuario user = usuarioRepository.findByIdUsuario(viajeApi.getIdUsuario());
			Usuario taxista = usuarioRepository.findByIdUsuario(0);

			int idTaxi = viajeApi.getIdTaxista();
			Viaje viajeAux = viajeRepository.findByIdViaje(viajeApi.getIdViaje());
			if(viajeAux ==  null) {
				Date fechaAux = new Date();
				@SuppressWarnings("deprecation")
				String fecha = fechaAux.getDay()+"/"+fechaAux.getMonth()+"/"+fechaAux.getYear();
				
			    @SuppressWarnings("deprecation")
				String hora = fechaAux.getHours()+"/"+fechaAux.getMinutes();
			    
			    viaje.setFechaViaje(fechaAux.toLocaleString());
			    viaje.setHoraInicio(fechaAux.toLocaleString());
				viaje.setCliente(user);
				viaje.setCosto(viajeApi.getCosto());
				viaje.setDestino(viajeApi.getDestino());
				viaje.setUbicacion(viajeApi.getUbicacion());
				viaje.setEstatus(viajeApi.getEstatus());			    
			    
				int idV = viajeRepository.save(viaje).getIdViaje();
				
				ViajeAux auxiliar = new ViajeAux();
				auxiliar.setIdViaje(idV);
				return auxiliar;

			}else {
			
				viaje.setCliente(viajeAux.getCliente());
				viaje.setCosto(viajeAux.getCosto());
				viaje.setDestino(viajeAux.getDestino());
				viaje.setFechaViaje(viajeAux.getFechaViaje());
				viaje.setHoraInicio(viajeAux.getHoraInicio());
				viaje.setUbicacion(viajeAux.getUbicacion());
				viaje.setEstatus(viajeApi.getEstatus());
				viaje.setIdViaje(viajeApi.getIdViaje());
				
				if(idTaxi != 0) {
					viaje.setTaxista(taxista);
				}
				int idV = viajeRepository.save(viaje).getIdViaje();
				
				ViajeAux auxiliar = new ViajeAux();
				auxiliar.setIdViaje(idV);
				return auxiliar;


			}
			
		}catch(Exception e) {
			System.out.println("Registro de viaje "+e);
			return null;
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
	
	public DetallesViaje getViajeId(int id) {
		try {
			Viaje viajeAux =  viajeRepository.findByIdViaje(id);
			DetallesViaje detalle = new DetallesViaje();
			if(viajeAux.getTaxista() != null) {
				 detalle.setChofer(viajeAux.getTaxista().getNombre());
				 detalle.setColor(viajeAux.getTaxista().getColor_auto());
				 detalle.setPlacas(viajeAux.getTaxista().getPlacas());
				 detalle.setModelo(viajeAux.getTaxista().getModelo_auto());
			}
			 detalle.setEstatus(viajeAux.getEstatus());
			 detalle.setCosto(viajeAux.getCosto());
			 detalle.setUbicacion(viajeAux.getUbicacion());
			 detalle.setDestino(viajeAux.getDestino());
			 detalle.setIdViaje(viajeAux.getIdViaje());
			 return detalle;
			
		}catch(Exception e){
			System.out.println("Consulta viaje "+e);
			return null;
		}
	}
	
	
}
