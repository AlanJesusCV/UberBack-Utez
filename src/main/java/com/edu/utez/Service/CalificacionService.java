package com.edu.utez.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utez.Entity.Calificacion;
import com.edu.utez.Entity.Usuario;
import com.edu.utez.Repository.CalificacionRepository;
import com.edu.utez.Repository.UsuarioRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class CalificacionService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CalificacionRepository calificacionRepository;

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

    public boolean saveCalificacion( Calificacion calificacion){
        try {
            Usuario TaxistaAux = usuarioRepository.findByIdUsuario(calificacion.getTaxista().getIdUsuario());
            Usuario ClienteAux = usuarioRepository.findByIdUsuario(calificacion.getCliente().getIdUsuario());

            calificacion.setCliente(ClienteAux);
            calificacion.setTaxista(TaxistaAux);

            return calificacionRepository.existsById(calificacionRepository.save(calificacion).getIdCalificacion());
        }catch (Exception e){
            System.out.println("Registro calificacion "+e);
            return false;
        }
    }




}
