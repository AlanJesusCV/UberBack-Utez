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
	public boolean enviarMensaje(@RequestBody Mensaje mensaje) {
		try {
			
			System.out.println("keys "+mensaje.getKeys().get(1));
			System.out.println("title "+mensaje.getMessageTitle());
			System.out.println("mensaje "+mensaje.getMessage());

			push.sendPushNotification(mensaje.getKeys(),mensaje.getMessageTitle() ,  mensaje.getMessage());
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
