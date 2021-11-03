package com.edu.utez.Entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
public class Viaje {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViaje;
    
    @ManyToOne
    @NotNull
    private Usuario taxista;

    @ManyToOne
    @NotNull
    private  Usuario cliente;
    
    @Null
    private String fechaViaje;
    
    @Null
    private String horaInicio;
    
    @NotNull
    private String ubicacion;
    
    @NotNull
    private String destino;
    
    @NotNull
    private String estatus;

	public Viaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

	public Usuario getTaxista() {
		return taxista;
	}

	public void setTaxista(Usuario taxista) {
		this.taxista = taxista;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public String getFechaViaje() {
		return fechaViaje;
	}

	public void setFechaViaje(String fechaViaje) {
		this.fechaViaje = fechaViaje;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


    
    

}
