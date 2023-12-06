/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TADEO
 * Clase que representa la entidad de una empresa transportista.
 * 
 * La entidad está mapeada a una tabla llamada "empresas_transportistas" en la base de datos.
 */
@Entity
@Table(name = "empresas_transportistas")
public class EmpresaTransportista implements Serializable {

    /** Identificador único de la empresa transportista. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre de la empresa transportista. */
    @Column(name = "nombre")
    private String nombre;
    
    /** Lista de transportes asociados a la empresa transportista. */
    @OneToMany(mappedBy = "empresaTransportista")
    private List<Transporte> transporte;

    /** Constructor por defecto. */
    public EmpresaTransportista() {}

    /**
     * Constructor que toma el nombre de la empresa como parámetro.
     * 
     * @param nombre El nombre de la empresa transportista.
     */
    public EmpresaTransportista(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor que toma el nombre y la lista de transportes como parámetros.
     * 
     * @param nombre     El nombre de la empresa transportista.
     * @param transporte Lista de transportes asociados a la empresa.
     */
    public EmpresaTransportista(String nombre, List<Transporte> transporte) {
        this.nombre = nombre;
        this.transporte = transporte;
    }
    
    /**
     * Obtiene el identificador único de la empresa transportista.
     * 
     * @return El ID de la empresa transportista.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la empresa transportista.
     * 
     * @param id El nuevo ID de la empresa transportista.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la empresa transportista.
     * 
     * @return El nombre de la empresa transportista.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la empresa transportista.
     * 
     * @param nombre El nuevo nombre de la empresa transportista.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de transportes asociados a la empresa transportista.
     * 
     * @return La lista de transportes.
     */
    public List<Transporte> getTransporte() {
        return transporte;
    }

    /**
     * Establece la lista de transportes asociados a la empresa transportista.
     * 
     * @param transporte La nueva lista de transportes.
     */
    public void setTransporte(List<Transporte> transporte) {
        this.transporte = transporte;
    }
    
    /**
     * Genera un código hash único para la empresa transportista.
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
     * Compara si dos empresas transportistas son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si las empresas transportistas son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmpresaTransportista)) {
            return false;
        }
        EmpresaTransportista other = (EmpresaTransportista) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena de la empresa transportista.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "EmpresaTransportista{" + "id=" + id + ", nombre=" + nombre + ", transporte=" + transporte + '}';
    }
    
}
