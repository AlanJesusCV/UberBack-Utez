package com.edu.utez.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.utez.Entity.Mensaje;
import com.edu.utez.Entity.Notificacion;
import com.edu.utez.Entity.Usuario;
import com.edu.utez.Service.UsuarioService;

@RestController
@RequestMapping("/uber")
@CrossOrigin(origins = "*",methods = {RequestMethod.POST})
public class ChatController {
	
	@Autowired
	PushNotificationServiceImpl push;
	
	@Autowired
	ViajeNotificationService nofication;
	
	@Autowired 
	UsuarioService usuarioService;
	
	
	@PostMapping("/enviarMensaje")
	public boolean enviarMensaje(@RequestBody Mensaje mensaje) {
		try {
			
			//System.out.println("keys "+mensaje.getKeys().get(1));
			//System.out.println("title "+mensaje.getMessageTitle());
			//System.out.println("mensaje "+mensaje.getMessage());
			
			//List<String> keys = new ArrayList<String>();
			
			//keys.add("cDm7ihyRQoSMCypl4UZ98X:APA91bH1yKxwbxsIyhqNdU3LneUykW6mJJXvPMZf8WZ6bSbukJMfBDw4tCjj89G-3p5tYx2izRIz6ATnf-4MhV-BjQOExfn00UDSiHP4IxxOERUsPyLjogL8e1Fhw00Ab2r1HUrBH6Fv");
			
			
			push.sendPushNotification(mensaje.getKeys(),mensaje.getMessageTitle() ,  mensaje.getMessage());
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@PostMapping("/enviarNotificacion")
	public boolean enviarNotificacion(@RequestBody Notificacion notificacion) {
		try {
			
			
			//System.out.println("keys "+mensaje.getKeys().get(1));
			//System.out.println("title "+mensaje.getMessageTitle());
			//System.out.println("mensaje "+mensaje.getMessage());
			List<String> keys = new ArrayList<String>();
			List<Usuario> users = usuarioService.filtroUsuario();
			
			for(int i = 0; i < users.size(); i++ ) {
				keys.add(users.get(i).getToken());
				System.out.println(keys.add(users.get(i).getToken()));
			}
			
			
			nofication.sendPushNotification(keys,"Hay un nuevo viaje" , "Da click para avanzar al viaje", notificacion.getIdViaje(), notificacion.getToken());
		
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
