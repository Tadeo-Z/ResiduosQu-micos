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
 * Clase que representa la entidad de Traslado.
 * 
 * La entidad está mapeada a una tabla llamada "traslados" en la base de datos.
 */
@Entity
@Table(name = "traslados")
public class Traslado implements Serializable {

    /** Identificador único del traslado. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Fecha de llegada del traslado. */
    @Column(name = "fechaLlegada", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaLlegada;
    
    /** Descripción del traslado posterior, puede ser nulo. */
    @Column(name = "trasladoPosterior", length = 300, nullable = true)
    private String trasladoPosterior;
    
    /** Origen del traslado. */
    @Column(name = "origen", length = 50, nullable = false)
    private String origen;
    
    /** Destino del traslado. */
    @Column(name = "destino", length = 50, nullable = false)
    private String destino;
    
    /** Relación One-to-Many con la entidad Transporte. */
    @OneToMany(mappedBy = "traslado")
    private List<Transporte> transporte;

    /** Constructor por defecto. */
    public Traslado() {
    }

    /**
     * Constructor que toma un ID como parámetro.
     * 
     * @param id El identificador único del traslado.
     */
    public Traslado(Long id) {
        this.id = id;
    }

    /**
     * Constructor que toma la fecha de llegada, la descripción del traslado posterior,
     * el origen, el destino y la lista de transportes como parámetros.
     * 
     * @param fechaLlegada        La fecha de llegada del traslado.
     * @param trasladoPosterior   La descripción del traslado posterior.
     * @param origen              El origen del traslado.
     * @param destino             El destino del traslado.
     * @param transporte          La lista de transportes asociados al traslado.
     */
    public Traslado(Calendar fechaLlegada, String trasladoPosterior, String origen, String destino, List<Transporte> transporte) {
        this.fechaLlegada = fechaLlegada;
        this.trasladoPosterior = trasladoPosterior;
        this.origen = origen;
        this.destino = destino;
        this.transporte = transporte;
    }
    
    /**
     * Obtiene el identificador único del traslado.
     * 
     * @return El ID del traslado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del traslado.
     * 
     * @param id El nuevo ID del traslado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de llegada del traslado.
     * 
     * @return La fecha de llegada.
     */
    public Calendar getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * Establece la fecha de llegada del traslado.
     * 
     * @param fechaLlegada La nueva fecha de llegada.
     */
    public void setFechaLlegada(Calendar fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * Obtiene la descripción del traslado posterior.
     * 
     * @return La descripción del traslado posterior.
     */
    public String getTrasladoPosterior() {
        return trasladoPosterior;
    }

    /**
     * Establece la descripción del traslado posterior.
     * 
     * @param trasladoPosterior La nueva descripción del traslado posterior.
     */
    public void setTrasladoPosterior(String trasladoPosterior) {
        this.trasladoPosterior = trasladoPosterior;
    }

    /**
     * Obtiene el origen del traslado.
     * 
     * @return El origen del traslado.
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Establece el origen del traslado.
     * 
     * @param origen El nuevo origen del traslado.
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * Obtiene el destino del traslado.
     * 
     * @return El destino del traslado.
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Establece el destino del traslado.
     * 
     * @param destino El nuevo destino del traslado.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene la lista de transportes asociados al traslado.
     * 
     * @return La lista de transportes.
     */
    public List<Transporte> getTransporte() {
        return transporte;
    }

    /**
     * Establece la lista de transportes asociados al traslado.
     * 
     * @param transporte La nueva lista de transportes.
     */
    public void setTransporte(List<Transporte> transporte) {
        this.transporte = transporte;
    }
    
    /**
     * Genera un código hash único para el traslado.
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
     * Compara si dos traslados son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si los traslados son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Traslado)) {
            return false;
        }
        Traslado other = (Traslado) object;
        return (this.id == null && other.id == null) || (this.id != null && this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena del traslado.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "Traslado{" +
               "id=" + id +
               ", fechaLlegada=" + fechaLlegada +
               ", trasladoPosterior=" + trasladoPosterior +
               ", origen=" + origen +
               ", destino=" + destino +
               ", transporte=" + transporte +
               '}';
    }
    
}
