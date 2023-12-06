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
@Table(name = "quimicos")
public class Quimico implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "esPeligroso", nullable = false)
    private boolean esPeligroso;
    
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    @ManyToOne()
    @JoinColumn(name = "idResiduo", nullable = true)
    private Residuo residuo;

    public Quimico() {}

    public Quimico(String nombre) {
        this.nombre = nombre;
    }

    public Quimico(boolean esPeligroso, String nombre, Residuo residuo) {
        this.esPeligroso = esPeligroso;
        this.nombre = nombre;
        this.residuo = residuo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEsPeligroso() {
        return esPeligroso;
    }

    public void setEsPeligroso(boolean esPeligroso) {
        this.esPeligroso = esPeligroso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
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
        if (!(object instanceof Quimico)) {
            return false;
        }
        Quimico other = (Quimico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quimico{" + "id=" + id + ", esPeligroso=" + esPeligroso + ", nombre=" + nombre + ", residuo=" + residuo + '}';
    }
    
}
