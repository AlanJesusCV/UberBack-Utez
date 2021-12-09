package com.edu.utez.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utez.Entity.AuxCalificacion;
import com.edu.utez.Entity.Calificacion;
import com.edu.utez.Entity.Usuario;
import com.edu.utez.Entity.Viaje;
import com.edu.utez.Repository.CalificacionRepository;
import com.edu.utez.Repository.UsuarioRepository;
import com.edu.utez.Repository.ViajeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class CalificacionService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CalificacionRepository calificacionRepository;
    
    @Autowired 
    ViajeRepository viajeRepository;

    public Calificacion getCalificacion (int id){
        try{
            return calificacionRepository.findCalificacionByIdCalificacion(id);
        }catch (Exception e){
            System.out.println("Consulta individual calficicacion "+e);
            return null;
        }
    }

    public List<Calificacion> getCalificaciones(){
        try{
            return calificacionRepository.findAll();
        }catch (Exception e){
            System.out.println("Consulta genereal calificaciones "+e);
            return null;
        }
    }

    public boolean saveCalificacion( AuxCalificacion calificacion){
        try {
        	
        	Viaje viaje = viajeRepository.findByIdViaje(calificacion.getIdViaje());
        	
            Usuario TaxistaAux = usuarioRepository.findByIdUsuario(viaje.getTaxista().getIdUsuario());
            Usuario ClienteAux = usuarioRepository.findByIdUsuario(viaje.getCliente().getIdUsuario());
            
            
            Calificacion calificacionAux = new Calificacion();
            
            
            calificacionAux.setCliente(ClienteAux);
            calificacionAux.setTaxista(TaxistaAux);
            calificacionAux.setViaje(viaje);
            calificacionAux.setCalificacion(calificacion.getCalificacion());
     

            return calificacionRepository.existsById(calificacionRepository.save(calificacionAux).getIdCalificacion());
        }catch (Exception e){
            System.out.println("Registro calificacion "+e);
            return false;
        }
    }




}
