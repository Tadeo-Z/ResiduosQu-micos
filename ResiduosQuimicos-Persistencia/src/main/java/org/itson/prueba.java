/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson;

import javax.swing.JOptionPane;
import org.itson.entidades.Productor;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.ProductorDAO;
import org.itson.interfaces.iProductor;

/**
 *
 * @author TADEO
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        iProductor productor = new ProductorDAO();
        
        Productor productorNuevo = new Productor(Long.MIN_VALUE, "Tadeo", null);
        try{
            productor.registrar(productorNuevo);
        }catch(PersistenciaException e){
            JOptionPane.showMessageDialog(null, "error en: " + e.getMessage());
        }
    }
    
}
