/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.itson.enumeradores.UnidadMedida;

/**
 *
 * @author TADEO
 */
@Entity
@Table(name = "residuos_solicitudes")
public class ResiduoSolicitud implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idResiduo")
    private Residuo residuo;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "unidadMedida")
    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;

    @ManyToOne()
    @JoinColumn(name = "id_solicitud", nullable = true)
    private Solicitud solicitud;
    
    public ResiduoSolicitud() {}

    public ResiduoSolicitud(Residuo residuo) {
        this.residuo = residuo;
    }

    public ResiduoSolicitud(Residuo residuo, int cantidad, UnidadMedida unidadMedida, Solicitud solicitud) {
        this.residuo = residuo;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.solicitud = solicitud;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
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
        if (!(object instanceof ResiduoSolicitud)) {
            return false;
        }
        ResiduoSolicitud other = (ResiduoSolicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResiduoSolicitud{" + "id=" + id + ", residuo=" + residuo + ", cantidad=" + cantidad + ", unidadMedida=" + unidadMedida + ", solicitud=" + solicitud + '}';
    }
    
}
