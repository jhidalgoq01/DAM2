/*
 * Este es un ejemplo de aplicación que realiza diferentes tipos de consultas
 * en una base de datos utilizando JPA y Hibernate.
 */
package com;

import entities.Categoria;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 * Clase principal de la aplicación.
 */
public class Prueba1JPA {

    public static void main(String[] args) {
        // Llamamos a diferentes métodos que realizan consultas
        consultaNamedQuery();
        consultaNativeQuery();
        consultaQuery();
        consultaCategoriasHQL();
    }

    /**
     * Realiza una consulta utilizando una named query definida en la entidad Categoria.
     */
    public static void consultaNamedQuery() {

        // Obtener la named query "Categoria.findAll" desde el EntityManager
        Query query = EMClass.EM.createNamedQuery("Categoria.findAll");

        // Obtener la lista de resultados
        List<Categoria> lista = (List<Categoria>) query.getResultList();
        System.out.println("Consulta Named Query:");
        // Imprimir los resultados
        for (Categoria a : lista) {
            System.out.println(a.getPkcategoria() + "   " + a.getNombre());
        }
        System.out.println("");

    }

    /**
     * Realiza una consulta nativa utilizando SQL directamente.
     */
    public static void consultaNativeQuery() {
        System.out.println("Consulta Native Query:");

        // Crear una consulta nativa para seleccionar pkcategoria y nombre de la tabla categoria
        Query query = EMClass.EM.createNativeQuery("select pkcategoria, nombre from categoria", Categoria.class);

        // Obtener la lista de resultados
        List<Categoria> lista = (List<Categoria>) query.getResultList();

        // Imprimir los resultados
        for (Categoria a : lista) {
            System.out.println(a.getPkcategoria() + "   " + a.getNombre());
        }
        System.out.println("");
    }

    /**
     * Realiza una consulta JPQL utilizando el lenguaje de consulta de JPA.
     */
    public static void consultaQuery() {
        System.out.println("Consulta JPQL:");

        // Crear una consulta JPQL para seleccionar todas las categorías
        Query query = EMClass.EM.createQuery("SELECT c from Categoria c");

        // Obtener la lista de resultados
        List<Categoria> lista = (List<Categoria>) query.getResultList();

        // Imprimir los resultados
        for (Categoria a : lista) {
            System.out.println(a.getPkcategoria() + "   " + a.getNombre());
        }
        System.out.println("");
    }

    /**
     * Realiza una consulta utilizando HQL (Hibernate Query Language).
     */
    public static void consultaCategoriasHQL() {
        System.out.println("Consulta HQL:");

        // Obtener la sesión de Hibernate desde el EntityManager
        Session session = (Session) EMClass.EM.getDelegate();

        // Crear la consulta HQL para seleccionar todas las categorías
        org.hibernate.query.Query<Categoria> query = session.createQuery("FROM Categoria", Categoria.class);

        // Obtener la lista de resultados
        List<Categoria> lista = query.getResultList();

        // Imprimir los resultados
        for (Categoria a : lista) {
            System.out.println(a.getPkcategoria() + "   " + a.getNombre());
        }
        System.out.println("");
    }
}
