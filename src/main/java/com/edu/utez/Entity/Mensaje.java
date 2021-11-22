package com.edu.utez.Entity;

import java.util.List;

import javax.persistence.Entity;

public class Mensaje {

	private List<String> keys;
	
	private String messaggeTitle;
	
	private String messagge;

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public String getMessaggeTitle() {
		return messaggeTitle;
	}

	public void setMessaggeTitle(String messaggeTitle) {
		this.messaggeTitle = messaggeTitle;
	}

	public String getMessagge() {
		return messagge;
	}

	public void setMessagge(String messagge) {
		this.messagge = messagge;
	}
	
	
}
