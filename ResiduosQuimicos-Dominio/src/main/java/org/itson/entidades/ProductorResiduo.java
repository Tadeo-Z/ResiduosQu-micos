/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TADEO
 *
 * Clase que representa la entidad de la relación entre un productor y un residuo.
 * 
 * La entidad está mapeada a una tabla llamada "productores_residuos" en la base de datos.
 */
@Entity
@Table(name = "productores_residuos")
public class ProductorResiduo implements Serializable {

    /** Identificador único de la relación entre productor y residuo. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Relación Many-to-One con la entidad Productor. */
    @ManyToOne
    @JoinColumn(name = "idProductor", nullable = true)
    private Productor productor;

    /** Relación Many-to-One con la entidad Residuo. */
    @ManyToOne
    @JoinColumn(name = "idResiduo")
    private Residuo residuo;

    /** Constructor por defecto. */
    public ProductorResiduo() {
    }

    /**
     * Constructor que toma el identificador como parámetro.
     * 
     * @param id El identificador único de la relación.
     */
    public ProductorResiduo(Long id) {
        this.id = id;
    }

    /**
     * Constructor que toma un productor y un residuo como parámetros.
     * 
     * @param productor El productor asociado a la relación.
     * @param residuo   El residuo asociado a la relación.
     */
    public ProductorResiduo(Productor productor, Residuo residuo) {
        this.productor = productor;
        this.residuo = residuo;
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
     * Obtiene el productor asociado a la relación.
     * 
     * @return El productor asociado.
     */
    public Productor getProductor() {
        return productor;
    }

    /**
     * Establece el productor asociado a la relación.
     * 
     * @param productor El nuevo productor asociado.
     */
    public void setProductor(Productor productor) {
        this.productor = productor;
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
     * Genera un código hash único para la relación entre productor y residuo.
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
     * Compara si dos relaciones entre productor y residuo son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si las relaciones son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProductorResiduo)) {
            return false;
        }
        ProductorResiduo other = (ProductorResiduo) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena de la relación entre productor y residuo.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "ProductorResiduo{" + "id=" + id + ", productor=" + productor + ", residuo=" + residuo + '}';
    }

}
