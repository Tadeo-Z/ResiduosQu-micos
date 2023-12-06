/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TADEO
 * Clase para manejar la conexión a la base de datos utilizando JPA.
 * Implementa el patrón Singleton para garantizar una única instancia de EntityManagerFactory.
 */
public class Conexion {

    /** Dirección de persistencia para la unidad de persistencia JPA. */
    private final String DIRECCION_PERSISTENCE = "org.itson_ResiduosQuimicos-Dominio_jar_1.0PU";

    /** Instancia única de EntityManagerFactory. */
    private static EntityManagerFactory entityManagerFactory;

    /** Instancia única de la clase Conexion. */
    private static Conexion conexion;

    /** Constructor privado para evitar instanciación externa. */
    private Conexion() {
        // Crea la EntityManagerFactory al inicializar la conexión.
        entityManagerFactory = Persistence.createEntityManagerFactory(DIRECCION_PERSISTENCE);
    }

    /**
     * Método para obtener la instancia única de la clase Conexion.
     *
     * @return La instancia única de Conexion.
     */
    public static EntityManagerFactory getConexion() {
        // Verifica si la instancia ya ha sido creada.
        if (conexion == null) {
            // Si no ha sido creada, crea una nueva instancia de Conexion.
            conexion = new Conexion();
        }
        // Devuelve la instancia única de EntityManagerFactory.
        return entityManagerFactory;
    }
}
