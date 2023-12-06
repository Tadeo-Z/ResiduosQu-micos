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
import javax.persistence.Table;

/**
 *
 * @author TADEO
 * Clase que representa la entidad de un productor.
 * 
 * La entidad está mapeada a una tabla llamada "productores" en la base de datos.
 */
@Entity
@Table(name = "productores")
public class Productor implements Serializable {

    /** Identificador único del productor. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Nombre del productor. */
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    /** Relación Many-to-One con la entidad ProductorResiduo. */
    @ManyToOne()
    @JoinColumn(name = "id_productor_residuo", nullable = true)
    private ProductorResiduo productorResiduo;
    
    /** Constructor por defecto. */
    public Productor(){}

    /**
     * Constructor que toma el nombre del productor como parámetro.
     * 
     * @param nombre El nombre del productor.
     */
    public Productor(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor que toma el nombre y un ProductorResiduo asociado como parámetros.
     * 
     * @param nombre           El nombre del productor.
     * @param productorResiduo El ProductorResiduo asociado.
     */
    public Productor(String nombre, ProductorResiduo productorResiduo) {
        this.nombre = nombre;
        this.productorResiduo = productorResiduo;
    }
    
    /**
     * Obtiene el identificador único del productor.
     * 
     * @return El ID del productor.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del productor.
     * 
     * @param id El nuevo ID del productor.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del productor.
     * 
     * @return El nombre del productor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del productor.
     * 
     * @param nombre El nuevo nombre del productor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ProductorResiduo asociado al productor.
     * 
     * @return El ProductorResiduo asociado.
     */
    public ProductorResiduo getProductorResiduo() {
        return productorResiduo;
    }

    /**
     * Establece el ProductorResiduo asociado al productor.
     * 
     * @param productorResiduo El nuevo ProductorResiduo asociado.
     */
    public void setProductorResiduo(ProductorResiduo productorResiduo) {
        this.productorResiduo = productorResiduo;
    }
    
    /**
     * Genera un código hash único para el productor.
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
     * Compara si dos productores son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si los productores son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Productor)) {
            return false;
        }
        Productor other = (Productor) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena del productor.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "Productor{" + "id=" + id + ", nombre=" + nombre + ", productorResiduo=" + productorResiduo + '}';
    }
    
}
