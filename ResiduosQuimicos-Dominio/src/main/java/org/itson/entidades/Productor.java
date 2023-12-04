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
@Table(name = "productores")
public class Productor implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "id_productor_residuo", nullable = true)
    private ProductorResiduo productorResiduo;
    
    public Productor(){}

    public Productor(String nombre) {
        this.nombre = nombre;
    }

    public Productor(Long id, String nombre, ProductorResiduo productorResiduo) {
        this.id = id;
        this.nombre = nombre;
        this.productorResiduo = productorResiduo;
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

    public ProductorResiduo getProductorResiduo() {
        return productorResiduo;
    }

    public void setProductorResiduo(ProductorResiduo productorResiduo) {
        this.productorResiduo = productorResiduo;
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
        if (!(object instanceof Productor)) {
            return false;
        }
        Productor other = (Productor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Productor{" + "id=" + id + ", nombre=" + nombre + ", productorResiduo=" + productorResiduo + '}';
    }
    
}
