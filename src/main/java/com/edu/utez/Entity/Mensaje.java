package com.edu.utez.Entity;

import java.util.List;

import javax.persistence.Entity;

public class Mensaje {

	private List<String> keys;
	
	private String messageTitle;
	
	private String message;

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	
}
