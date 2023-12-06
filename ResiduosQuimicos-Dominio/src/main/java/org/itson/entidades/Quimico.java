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
 *
 *
 * Clase que representa la entidad de productos químicos.
 * 
 * La entidad está mapeada a una tabla llamada "quimicos" en la base de datos.
 */
@Entity
@Table(name = "quimicos")
public class Quimico implements Serializable {

    /** Identificador único del químico. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Indica si el químico es peligroso o no. */
    @Column(name = "esPeligroso", nullable = false)
    private boolean esPeligroso;
    
    /** Nombre del químico. */
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    /** Relación Many-to-One con la entidad Residuo. */
    @ManyToOne()
    @JoinColumn(name = "idResiduo", nullable = true)
    private Residuo residuo;

    /** Constructor por defecto. */
    public Quimico() {}

    /**
     * Constructor que toma el nombre como parámetro.
     * 
     * @param nombre El nombre del químico.
     */
    public Quimico(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor que toma la peligrosidad, nombre y residuo como parámetros.
     * 
     * @param esPeligroso Indica si el químico es peligroso.
     * @param nombre      El nombre del químico.
     * @param residuo     El residuo asociado al químico.
     */
    public Quimico(boolean esPeligroso, String nombre, Residuo residuo) {
        this.esPeligroso = esPeligroso;
        this.nombre = nombre;
        this.residuo = residuo;
    }
    
    /**
     * Obtiene el identificador único del químico.
     * 
     * @return El ID del químico.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del químico.
     * 
     * @param id El nuevo ID del químico.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Verifica si el químico es peligroso.
     * 
     * @return `true` si el químico es peligroso, `false` en caso contrario.
     */
    public boolean isEsPeligroso() {
        return esPeligroso;
    }

    /**
     * Establece si el químico es peligroso.
     * 
     * @param esPeligroso El nuevo valor para la peligrosidad del químico.
     */
    public void setEsPeligroso(boolean esPeligroso) {
        this.esPeligroso = esPeligroso;
    }

    /**
     * Obtiene el nombre del químico.
     * 
     * @return El nombre del químico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del químico.
     * 
     * @param nombre El nuevo nombre del químico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el residuo asociado al químico.
     * 
     * @return El residuo asociado.
     */
    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * Establece el residuo asociado al químico.
     * 
     * @param residuo El nuevo residuo asociado.
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Genera un código hash único para el químico.
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
     * Compara si dos químicos son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si los químicos son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Quimico)) {
            return false;
        }
        Quimico other = (Quimico) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena del químico.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "Quimico{" + "id=" + id + ", esPeligroso=" + esPeligroso + ", nombre=" + nombre + ", residuo=" + residuo + '}';
    }
    
}
