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
 *
 * Clase que representa la entidad de Solicitud.
 * 
 * La entidad está mapeada a una tabla llamada "solicitudes" en la base de datos.
 */
@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable {

    /** Identificador único de la solicitud. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Fecha en que se realiza la solicitud. */
    @Column(name = "fechaSolicitud", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaSolicitud;
    
    /** Relación One-to-Many con la entidad ResiduoSolicitud. */
    @OneToMany(mappedBy = "solicitud")
    private List<ResiduoSolicitud> residuoSolicitud;

    /** Constructor por defecto. */
    public Solicitud() {
    }

    /**
     * Constructor que toma un ID como parámetro.
     * 
     * @param id El identificador único de la solicitud.
     */
    public Solicitud(Long id) {
        this.id = id;
    }

    /**
     * Constructor que toma la fecha de solicitud y una lista de ResiduoSolicitud como parámetros.
     * 
     * @param fechaSolicitud    La fecha en que se realiza la solicitud.
     * @param residuoSolicitud  La lista de relaciones entre residuos y la solicitud.
     */
    public Solicitud(Calendar fechaSolicitud, List<ResiduoSolicitud> residuoSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
        this.residuoSolicitud = residuoSolicitud;
    }
    
    /**
     * Obtiene el identificador único de la solicitud.
     * 
     * @return El ID de la solicitud.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la solicitud.
     * 
     * @param id El nuevo ID de la solicitud.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha en que se realiza la solicitud.
     * 
     * @return La fecha de solicitud.
     */
    public Calendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Establece la fecha en que se realiza la solicitud.
     * 
     * @param fechaSolicitud La nueva fecha de solicitud.
     */
    public void setFechaSolicitud(Calendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * Obtiene la lista de relaciones ResiduoSolicitud asociadas a la solicitud.
     * 
     * @return La lista de ResiduoSolicitud.
     */
    public List<ResiduoSolicitud> getResiduoSolicitud() {
        return residuoSolicitud;
    }

    /**
     * Establece la lista de relaciones ResiduoSolicitud asociadas a la solicitud.
     * 
     * @param residuoSolicitud La nueva lista de ResiduoSolicitud.
     */
    public void setResiduoSolicitud(List<ResiduoSolicitud> residuoSolicitud) {
        this.residuoSolicitud = residuoSolicitud;
    }
    
    /**
     * Genera un código hash único para la solicitud.
     * 
     * @return El código hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si dos solicitudes son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si las solicitudes son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        return (this.id == null && other.id == null) || (this.id != null && this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena de la solicitud.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "Solicitud{" +
               "id=" + id +
               ", fechaSolicitud=" + fechaSolicitud +
               ", residuoSolicitud=" + residuoSolicitud +
               '}';
    }
    
}
