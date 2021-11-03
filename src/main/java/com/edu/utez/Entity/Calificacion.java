package com.edu.utez.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.edu.utez.Entity.Usuario;
@Entity
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalificacion;

    @ManyToOne
    @NotNull
    private Usuario taxista;

    @ManyToOne
    @NotNull
    private  Usuario cliente;

    @NotNull
    private int calificacion;

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
