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
 *
 * Clase que representa la entidad de residuos.
 * 
 * La entidad está mapeada a una tabla llamada "residuos" en la base de datos.
 */
@Entity
@Table(name = "residuos")
public class Residuo implements Serializable {

    /** Identificador único del residuo. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Código único asignado al residuo. */
    @Column(name = "codigoResiduo", nullable = false)
    private String codigoResiduo;
    
    /** Cantidad del residuo. */
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
    /** Relación Many-to-One con la entidad ProductorResiduo. */
    @ManyToOne()
    @JoinColumn(name = "id_productor_residuo", nullable = true)
    private ProductorResiduo productorResiduo;
    
    /** Relación One-to-Many con la entidad Quimico. */
    @OneToMany(mappedBy = "residuo")
    private List<Quimico> quimicos;

    /** Constructor por defecto. */
    public Residuo() {}

    /**
     * Constructor que toma el código del residuo como parámetro.
     * 
     * @param codigoResiduo El código único del residuo.
     */
    public Residuo(String codigoResiduo) {
        this.codigoResiduo = codigoResiduo;
    }

    /**
     * Constructor que toma el código, cantidad, productorResiduo y químicos como parámetros.
     * 
     * @param codigoResiduo     El código único del residuo.
     * @param cantidad          La cantidad del residuo.
     * @param productorResiduo  El productor de residuo asociado.
     * @param quimicos          La lista de químicos asociados al residuo.
     */
    public Residuo(String codigoResiduo, int cantidad, ProductorResiduo productorResiduo, List<Quimico> quimicos) {
        this.codigoResiduo = codigoResiduo;
        this.cantidad = cantidad;
        this.productorResiduo = productorResiduo;
        this.quimicos = quimicos;
    }
    
    /**
     * Obtiene el identificador único del residuo.
     * 
     * @return El ID del residuo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del residuo.
     * 
     * @param id El nuevo ID del residuo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el código único asignado al residuo.
     * 
     * @return El código del residuo.
     */
    public String getCodigoResiduo() {
        return codigoResiduo;
    }

    /**
     * Establece el código único del residuo.
     * 
     * @param codigoResiduo El nuevo código del residuo.
     */
    public void setCodigoResiduo(String codigoResiduo) {
        this.codigoResiduo = codigoResiduo;
    }

    /**
     * Obtiene la cantidad del residuo.
     * 
     * @return La cantidad del residuo.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del residuo.
     * 
     * @param cantidad La nueva cantidad del residuo.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el productor de residuo asociado.
     * 
     * @return El productor de residuo.
     */
    public ProductorResiduo getProductorResiduo() {
        return productorResiduo;
    }

    /**
     * Establece el productor de residuo asociado.
     * 
     * @param productorResiduo El nuevo productor de residuo.
     */
    public void setProductorResiduo(ProductorResiduo productorResiduo) {
        this.productorResiduo = productorResiduo;
    }

    /**
     * Obtiene la lista de químicos asociados al residuo.
     * 
     * @return La lista de químicos.
     */
    public List<Quimico> getQuimicos() {
        return quimicos;
    }

    /**
     * Establece la lista de químicos asociados al residuo.
     * 
     * @param quimicos La nueva lista de químicos.
     */
    public void setQuimicos(List<Quimico> quimicos) {
        this.quimicos = quimicos;
    }
    
    /**
     * Genera un código hash único para el residuo.
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
     * Compara si dos residuos son iguales.
     * 
     * @param object El objeto a comparar.
     * @return `true` si los residuos son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Residuo)) {
            return false;
        }
        Residuo other = (Residuo) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     * Obtiene una representación en cadena del residuo.
     * 
     * @return La representación en cadena.
     */
    @Override
    public String toString() {
        return "Residuo{" + "id=" + id + ", codigoResiduo=" + codigoResiduo + ", cantidad=" + cantidad + ", productorResiduo=" + productorResiduo + ", quimicos=" + quimicos + '}';
    }
    
}
