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

@RestController
@RequestMapping("/uber")
@CrossOrigin(origins = "*",methods = {RequestMethod.POST})
public class ChatController {
	
	@Autowired
	PushNotificationServiceImpl push;
	
	@PostMapping("/enviarMensaje")
	public Mensaje enviarMensaje(@RequestBody Mensaje mensaje) {
		try {
			
			System.out.println("keys "+mensaje.getKeys().get(1));
			System.out.println("title "+mensaje.toString());
			System.out.println("mensaje "+mensaje);

			push.sendPushNotification(mensaje.getKeys(),mensaje.getMessaggeTitle() ,  mensaje.getMessagge());
			return mensaje;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
