/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.entidades;

import javax.persistence.Temporal;
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
import javax.persistence.TemporalType;

/**
 *
 * @author TADEO
 */
@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaSolicitud", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaSolicitud;
    
    @OneToMany(mappedBy = "solicitud")
    private List<ResiduoSolicitud> residuoSolicitud;

    public Solicitud() {
    }

    public Solicitud(Long id) {
        this.id = id;
    }

    public Solicitud(Calendar fechaSolicitud, List<ResiduoSolicitud> residuoSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
        this.residuoSolicitud = residuoSolicitud;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Calendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public List<ResiduoSolicitud> getResiduoSolicitud() {
        return residuoSolicitud;
    }

    public void setResiduoSolicitud(List<ResiduoSolicitud> residuoSolicitud) {
        this.residuoSolicitud = residuoSolicitud;
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
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "id=" + id + ", fechaSolicitud=" + fechaSolicitud + ", residuoSolicitud=" + residuoSolicitud + '}';
    }
    
}
