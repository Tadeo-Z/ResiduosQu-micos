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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TADEO
 */
@Entity
@Table(name = "residuos")
public class Residuo implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigoResiduo", nullable = false)
    private String codigoResiduo;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
    @ManyToOne()
    @JoinColumn(name = "id_productor_residuo", nullable = true)
    private ProductorResiduo productorResiduo;
    
    @OneToMany(mappedBy = "residuo")
    private List<Quimico> quimicos;

    public Residuo() {}

    public Residuo(String codigoResiduo) {
        this.codigoResiduo = codigoResiduo;
    }

    public Residuo(String codigoResiduo, int cantidad, ProductorResiduo productorResiduo, List<Quimico> quimicos) {
        this.codigoResiduo = codigoResiduo;
        this.cantidad = cantidad;
        this.productorResiduo = productorResiduo;
        this.quimicos = quimicos;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoResiduo() {
        return codigoResiduo;
    }

    public void setCodigoResiduo(String codigoResiduo) {
        this.codigoResiduo = codigoResiduo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductorResiduo getProductorResiduo() {
        return productorResiduo;
    }

    public void setProductorResiduo(ProductorResiduo productorResiduo) {
        this.productorResiduo = productorResiduo;
    }

    public List<Quimico> getQuimicos() {
        return quimicos;
    }

    public void setQuimicos(List<Quimico> quimicos) {
        this.quimicos = quimicos;
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
        if (!(object instanceof Residuo)) {
            return false;
        }
        Residuo other = (Residuo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Residuo{" + "id=" + id + ", codigoResiduo=" + codigoResiduo + ", cantidad=" + cantidad + ", productorResiduo=" + productorResiduo + ", quimicos=" + quimicos + '}';
    }
    
}
