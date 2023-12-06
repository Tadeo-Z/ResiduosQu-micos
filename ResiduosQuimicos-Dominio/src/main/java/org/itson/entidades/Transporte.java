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
 * Clase que representa la entidad de Transporte.
 * 
 * La entidad está mapeada a una tabla llamada "transportes" en la base de datos.
 */
@Entity
@Table(name = "transportes")
public class Transporte implements Serializable {

    /** Identificador único del transporte. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Kilómetros recorridos por el transporte. */
    @Column(name = "kilometros")
    private float kilometros;
    
    /** Relación Many-to-One con la entidad EmpresaTransportista. */
    @ManyToOne()
    @JoinColumn(name = "id_empresa_transportista", nullable = true)
    private EmpresaTransportista empresaTransportista;
    
    /** Relación Many-to-One con la entidad Traslado. */
    @ManyToOne()
    @JoinColumn(name = "id_traslado", nullable = true)
    private Traslado traslado;

    /** Constructor por defecto. */
    public Transporte() {}

    /**
     * Constructor que toma un ID como parámetro.
     * 
     * @param id El identificador único del transporte.
     */
    public Transporte(Long id) {
        this.id = id;
    }

    /**
     * Constructor que toma los kilómetros, la empresa transportista y el traslado como parámetros.
     * 
     * @param kilometros          Los kilómetros recorridos por el transporte.
     * @param empresaTransportista La empresa transportista asociada al transporte.
     * @param traslado            El traslado asociado al transporte.
     */
    public Transporte(float kilometros, EmpresaTransportista empresaTransportista, Traslado traslado) {
        this.kilometros = kilometros;
        this.empresaTransportista = empresaTransportista;
        this.traslado = traslado;
    }
    
    /**
     * Obtiene el identificador único del transporte.
     * 
     * @return El ID del transporte.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del transporte.
     * 
     * @param id El nuevo ID del transporte.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene los kilómetros recorridos por el transporte.
     * 
     * @return Los kilómetros recorridos.
     */
    public float getKilometros() {
        return kilometros;
    }

    /**
     * Establece los kilómetros recorridos por el transporte.
     * 
     * @param kilometros Los nuevos kilómetros recorridos.
     */
    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * Obtiene la empresa transportista asociada al transporte.
     * 
     * @return La empresa transportista.
     */
    public EmpresaTransportista getEmpresaTransportista() {
        return empresaTransportista;
    }

    /**
     * Establece la empresa transportista asociada al transporte.
     * 
     * @param empresaTransportista La nueva empresa transportista.
     */
    public void setEmpresaTransportista(EmpresaTransportista empresaTransportista) {
        this.empresaTransportista = empresaTransportista;
    }

    /**
     * Obtiene el traslado asociado al transporte.
     * 
     * @return El traslado asociado.
     */
    public Traslado getTraslado() {
        return traslado;
    }

    /**
     * Establece el traslado asociado al transporte.
     * 
     * @param traslado El nuevo traslado.
     */
    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }
    
    /**
     * Genera un código hash único para el transporte.
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
     * Compara si dos transportes son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si los transportes son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        return (this.id == null && other.id == null) || (this.id != null && this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena del transporte.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "Transporte{" +
               "id=" + id +
               ", kilometros=" + kilometros +
               ", empresaTransportista=" + empresaTransportista +
               ", traslado=" + traslado +
               '}';
    }
    
}
