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
 */
@Entity
@Table(name = "transportes")
public class Transporte implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "kilometros")
    private float kilometros;
    
    @ManyToOne()
    @JoinColumn(name = "id_empresa_transportista", nullable = true)
    private EmpresaTransportista empresaTransportista;
    
    @ManyToOne()
    @JoinColumn(name = "id_traslado", nullable = true)
    private Traslado traslado;

    public Transporte() {}

    public Transporte(Long id) {
        this.id = id;
    }

    public Transporte(float kilometros, EmpresaTransportista empresaTransportista, Traslado traslado) {
        this.kilometros = kilometros;
        this.empresaTransportista = empresaTransportista;
        this.traslado = traslado;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getKilometros() {
        return kilometros;
    }

    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }

    public EmpresaTransportista getEmpresaTransportista() {
        return empresaTransportista;
    }

    public void setEmpresaTransportista(EmpresaTransportista empresaTransportista) {
        this.empresaTransportista = empresaTransportista;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
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
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transporte{" + "id=" + id + ", kilometros=" + kilometros + ", empresaTransportista=" + empresaTransportista + ", traslado=" + traslado + '}';
    }
    
}
