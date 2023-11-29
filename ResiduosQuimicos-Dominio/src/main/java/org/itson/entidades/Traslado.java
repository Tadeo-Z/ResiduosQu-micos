/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author TADEO
 */
@Entity
@Table(name = "traslados")
public class Traslado implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaLlegada", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaLlegada;
    
    @Column(name = "trasladoPosterior", length = 300, nullable = true)
    private String trasladoPosterior;
    
    @Column(name = "origen", length = 50, nullable = false)
    private String origen;
    
    @Column(name = "destino", length = 50, nullable = false)
    private String destino;
    
    @OneToMany(mappedBy = "traslado")
    private List<Transporte> transporte;

    public Traslado() {
    }

    public Traslado(Long id) {
        this.id = id;
    }

    public Traslado(Long id, Calendar fechaLlegada, String trasladoPosterior, String origen, String destino, List<Transporte> transporte) {
        this.id = id;
        this.fechaLlegada = fechaLlegada;
        this.trasladoPosterior = trasladoPosterior;
        this.origen = origen;
        this.destino = destino;
        this.transporte = transporte;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Calendar fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getTrasladoPosterior() {
        return trasladoPosterior;
    }

    public void setTrasladoPosterior(String trasladoPosterior) {
        this.trasladoPosterior = trasladoPosterior;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public List<Transporte> getTransporte() {
        return transporte;
    }

    public void setTransporte(List<Transporte> transporte) {
        this.transporte = transporte;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traslado)) {
            return false;
        }
        Traslado other = (Traslado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Traslado{" + "id=" + id + ", fechaLlegada=" + fechaLlegada + ", trasladoPosterior=" + trasladoPosterior + ", origen=" + origen + ", destino=" + destino + ", transporte=" + transporte + '}';
    }
    
}
