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
import com.edu.utez.Entity.NotificacionPersonal;
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
	
	@Autowired
	PersonalNotification personalNotificacion;
	
	
	@PostMapping("/enviarMensaje")
	public boolean enviarMensaje(@RequestBody Mensaje mensaje) {
		try {
			
			//System.out.println("keys "+mensaje.getKeys().get(1));
			//System.out.println("title "+mensaje.getMessageTitle());
			//System.out.println("mensaje "+mensaje.getMessage());
			
			//List<String> keys = new ArrayList<String>();
			
			//keys.add("cKAEab2vTbOUPJ3QNo8Xcn:APA91bEyWSy82_LRbJmU_IquU6POIqT1Fnfl0ZQBx47p_eMtBeRZAEuSzeYJ6ykjvZvm75cTJTDuVsgjonWc8ox5zMWO_WCapqQoXxukua2-YIFApyCobvefrPZgoCJimPLLb9_LmrPL");
			//keys.add( "ciB4deNRQfqYRm8ynfB-zL:APA91bEy23CYRQuWo8GFkQ0ya-5Xet65HM_yU4pp4VOBDM3mYraxtRRuBw_BXe9pS20LgzGE_GHP3jbOilLjarEm73Co9D4o-cc2kqECVdF3BSREfomg4A34mlCCGnpI-1zezU54dX0M");
			
			
			push.sendPushNotification(mensaje.getKeys(),mensaje.getMessageTitle() ,  mensaje.getMessage());
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@PostMapping("/enviarNotificacionPersonal")
	public boolean enviarNotificacionPersonal(@RequestBody NotificacionPersonal notificacion) {
		try {
			
			
			//System.out.println("keys "+mensaje.getKeys().get(1));
			//System.out.println("title "+mensaje.getMessageTitle());
			//System.out.println("mensaje "+mensaje.getMessage());
			
			personalNotificacion.sendPushNotification(notificacion.getKeys(), notificacion.getTitle() , notificacion.getMensaje(),
					notificacion.getIdViaje(), notificacion.getToken());
		
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
			
			nofication.sendPushNotification( keys , notificacion.getTitle() ,notificacion.getMensaje(),
					notificacion.getIdViaje(), notificacion.getToken(), notificacion.getDe(), notificacion.getA() );
		
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
