package com.edu.utez.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu.utez.Entity.AuxCalificacion;
import com.edu.utez.Entity.Calificacion;
import com.edu.utez.Service.CalificacionService;
import com.edu.utez.Service.UsuarioService;

@RestController
@RequestMapping("/uber")
@CrossOrigin(origins = "*",methods =
        {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")

public class CalificacionController {

	@Autowired
    private CalificacionService calificacionService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/calificacion/getCalificacion/{id}")
    public Calificacion getCalificacion(@PathVariable("id") int id){
        return calificacionService.getCalificacion(id);
    }

    @PostMapping("/calificacion/saveCalificacion")
    public boolean saveCalificacion(@RequestBody AuxCalificacion calificacion){
        return calificacionService.saveCalificacion(calificacion);
    }


}
