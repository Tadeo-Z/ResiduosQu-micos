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
 * Clase que representa la entidad de relación entre Residuo y Solicitud.
 * 
 * La entidad está mapeada a una tabla llamada "residuos_solicitudes" en la base de datos.
 */
@Entity
@Table(name = "residuos_solicitudes")
public class ResiduoSolicitud implements Serializable {

    /** Identificador único de la relación residuo-solicitud. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Relación Many-to-One con la entidad Residuo. */
    @ManyToOne
    @JoinColumn(name = "idResiduo")
    private Residuo residuo;
    
    /** Cantidad del residuo en la solicitud. */
    @Column(name = "cantidad")
    private int cantidad;
    
    /** Unidad de medida para la cantidad del residuo en la solicitud. */
    @Column(name = "unidadMedida")
    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;

    /** Relación Many-to-One con la entidad Solicitud. */
    @ManyToOne()
    @JoinColumn(name = "id_solicitud", nullable = true)
    private Solicitud solicitud;
    
    /** Constructor por defecto. */
    public ResiduoSolicitud() {}

    /**
     * Constructor que toma un residuo como parámetro.
     * 
     * @param residuo El residuo asociado a la relación.
     */
    public ResiduoSolicitud(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Constructor que toma un residuo, cantidad, unidad de medida y solicitud como parámetros.
     * 
     * @param residuo       El residuo asociado a la relación.
     * @param cantidad      La cantidad del residuo en la solicitud.
     * @param unidadMedida  La unidad de medida para la cantidad.
     * @param solicitud     La solicitud asociada a la relación.
     */
    public ResiduoSolicitud(Residuo residuo, int cantidad, UnidadMedida unidadMedida, Solicitud solicitud) {
        this.residuo = residuo;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.solicitud = solicitud;
    }
    
    /**
     * Obtiene el identificador único de la relación.
     * 
     * @return El ID de la relación.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la relación.
     * 
     * @param id El nuevo ID de la relación.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el residuo asociado a la relación.
     * 
     * @return El residuo asociado.
     */
    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * Establece el residuo asociado a la relación.
     * 
     * @param residuo El nuevo residuo asociado.
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Obtiene la cantidad del residuo en la solicitud.
     * 
     * @return La cantidad del residuo.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del residuo en la solicitud.
     * 
     * @param cantidad La nueva cantidad del residuo.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la unidad de medida para la cantidad del residuo.
     * 
     * @return La unidad de medida.
     */
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Establece la unidad de medida para la cantidad del residuo.
     * 
     * @param unidadMedida La nueva unidad de medida.
     */
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     * Obtiene la solicitud asociada a la relación.
     * 
     * @return La solicitud asociada.
     */
    public Solicitud getSolicitud() {
        return solicitud;
    }

    /**
     * Establece la solicitud asociada a la relación.
     * 
     * @param solicitud La nueva solicitud asociada.
     */
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    /**
     * Genera un código hash único para la relación residuo-solicitud.
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
     * Compara si dos relaciones residuo-solicitud son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si las relaciones son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ResiduoSolicitud)) {
            return false;
        }
        ResiduoSolicitud other = (ResiduoSolicitud) object;
        return (this.id == null && other.id == null) || (this.id != null && this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena de la relación residuo-solicitud.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "ResiduoSolicitud{" +
               "id=" + id +
               ", residuo=" + residuo +
               ", cantidad=" + cantidad +
               ", unidadMedida=" + unidadMedida +
               ", solicitud=" + solicitud +
               '}';
    }
    
}
