package com.edu.utez.Controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

 @Service
public class PersonalNotification {
    private final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
    private final String FIREBASE_SERVER_KEY = "AAAAdFHT1XQ:APA91bG4bTbJsdhlvlj9j40-YJ2O_5pQuEeCGNJ8W7HapqEbizI7k_Vgj85eaXl9W011w8d0oA9KUuid6ZqzeZKMfCsJSzcddr7x-x0svf3zpm8ZV3YcDb_-0PC5ghS3D204H9i27dOJ";


    public void sendPushNotification(List<String> keys, String messageTitle, String message, int idViaje, String token ) {


    	JSONObject msg = new JSONObject();

        msg.put("title", messageTitle);
        msg.put("body", message);
        msg.put("notificationType", "Test");
        msg.put("idViaje", idViaje);
        msg.put("token", token);

        

        keys.forEach(key -> {
            System.out.println("\nCalling fcm Server >>>>>>>");
            String response = callToFcmServer(msg, key);
            System.out.println("Got response from fcm Server : " + response + "\n\n");
        });

    }

    private String callToFcmServer(JSONObject message, String receiverFcmKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "key=" + FIREBASE_SERVER_KEY);
        httpHeaders.set("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        json.put("data", message);
        json.put("notification", message);
        json.put("to", receiverFcmKey);

        System.out.println("Sending :" + json.toString());

        HttpEntity<String> httpEntity = new HttpEntity<>(json.toString(), httpHeaders);
        return restTemplate.postForObject(FIREBASE_API_URL, httpEntity, String.class);
    }
}