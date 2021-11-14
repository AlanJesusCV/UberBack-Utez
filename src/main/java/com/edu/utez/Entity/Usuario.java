package com.edu.utez.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@NotNull
	private String nombre;
	
	@NotNull
	@Column(unique = true )
	private String email;
	
	@NotNull
	@Column(unique = true)
	private String telefono;
	
	@NotNull
	private String password;

	private String placas;

	private String modelo_auto;

	private String color_auto;

	private boolean logeado;

	private double latitud_actual;

	private double longitud_actual;
	
	@ManyToMany
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private List<Rol> roles = new ArrayList<Rol>();
	
	public Usuario() {
		
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlacas() {
		return placas;
	}

	public void setPlacas(String placas) {
		this.placas = placas;
	}

	public String getModelo_auto() {
		return modelo_auto;
	}

	public void setModelo_auto(String modelo_auto) {
		this.modelo_auto = modelo_auto;
	}

	public String getColor_auto() {
		return color_auto;
	}

	public void setColor_auto(String color_auto) {
		this.color_auto = color_auto;
	}

	public boolean isLogeado() {
		return logeado;
	}

	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}

	public double getLatitud_actual() {
		return latitud_actual;
	}

	public void setLatitud_actual(double latitud_actual) {
		this.latitud_actual = latitud_actual;
	}

	public double getLongitud_actual() {
		return longitud_actual;
	}

	public void setLongitud_actual(double longitud_actual) {
		this.longitud_actual = longitud_actual;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}
