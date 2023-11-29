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
 */
@Entity
@Table(name = "empresas_transportistas")
public class EmpresaTransportista implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "empresaTransportista")
    private List<Transporte> transporte;

    public EmpresaTransportista() {}

    public EmpresaTransportista(String nombre) {
        this.nombre = nombre;
    }

    public EmpresaTransportista(Long id, String nombre, List<Transporte> transporte) {
        this.id = id;
        this.nombre = nombre;
        this.transporte = transporte;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Transporte> getTransporte() {
        return transporte;
    }

    public void setTransporte(List<Transporte> transporte) {
        this.transporte = transporte;
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
        if (!(object instanceof EmpresaTransportista)) {
            return false;
        }
        EmpresaTransportista other = (EmpresaTransportista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpresaTransportista{" + "id=" + id + ", nombre=" + nombre + ", transporte=" + transporte + '}';
    }
    
}
