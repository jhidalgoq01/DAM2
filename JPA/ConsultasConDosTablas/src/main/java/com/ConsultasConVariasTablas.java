/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com;

import entities.Categoria;
import entities.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Yo
 */
public class ConsultasConVariasTablas {

    public static void main(String[] args) {
        consultaNamedQuery();
        consultaNativeQuery();
        consultaQuery();
        consultaHQL();
    }

    /**
     * Realiza una consulta utilizando una named query definida en la entidad Categoria.
     * <p>
     * Hacemos consultas de los productos de</p>
     * categoria 100
     *
     * WEn un principio no hay NamedQuery para buscar coincidecias con otras tablas pero se puede hacer. No aconsejable, es
     * preferible usar otro tipo de consulta
     */
    public static void consultaNamedQuery() {

        Query query = EMClass.EM.createNamedQuery("Producto.findByFkCategoria");
        Query query1 = EMClass.EM.createNamedQuery("Categoria.findByPkcategoria");

        Categoria categoria = (Categoria) query1.setParameter("pkcategoria", 100).getSingleResult();

        query.setParameter("fkcategoria", categoria);
        System.out.println("Consulta Named Query:");

        List<Producto> lista = (List<Producto>) query.getResultList();

        for (Producto p : lista) {
            System.out.println(p.getFkcategoria().getNombre() + "   " + p.getNombre());
        }
        System.out.println("");
    }

    public static void consultaNativeQuery() {
        System.out.println("Consulta Native Query:");

        // Supongamos que el EntityManager es obtenido de alguna manera (EMClass.EM)
        EntityManager em = EMClass.EM;

        // Crear la consulta nativa para obtener la categoría
        Query query1 = em.createNativeQuery("SELECT * FROM Categoria WHERE pkcategoria = ?", Categoria.class);
        Categoria categoria = (Categoria) query1.setParameter(1, 100).getSingleResult();

        // Crear la consulta nativa para obtener los productos
        Query query
                = em.createNativeQuery("SELECT * FROM Producto  WHERE fkcategoria = " + categoria.getPkcategoria(), Producto.class);
        //query.setParameter(1, categoria);

        // Obtener la lista de resultados
        List<Producto> lista = query.getResultList();

        // Imprimir los resultados
        for (Producto p : lista) {
            System.out.println(p.getFkcategoria().getNombre() + "   " + p.getNombre());
        }
        System.out.println("");
    }

    public static void consultaQuery() {
        System.out.println("Consulta JPQL:");
        Integer i = 100; // la pkcategoria que busco en los productos
        // Crear una consulta JPQL para seleccionar todas las categorías
        Query query1 = EMClass.EM.createQuery("SELECT c FROM Categoria c WHERE pkcategoria = :pkcategoria", Categoria.class);
        query1.setParameter("pkcategoria", i);
        Categoria cat = (Categoria) query1.getSingleResult();

        Query query = EMClass.EM.createQuery("SELECT p from Producto p WHERE p.fkcategoria = :fkcategoria");
        query.setParameter("fkcategoria", cat);
        // Obtener la lista de resultados
        List<Producto> lista = (List<Producto>) query.getResultList();

        // Imprimir los resultados
        for (Producto a : lista) {
            System.out.println(a.getFkcategoria().getNombre() + "   " + a.getNombre());
        }
        System.out.println("");
    }

    public static void consultaHQL() {
        System.out.println("Consulta HQL:");

        // Supongamos que el Session es obtenido de alguna manera (EMClass.EM.unwrap(Session.class))
        Session session = (Session) EMClass.EM.getDelegate();

        Integer i = 100; // la pkcategoria que busco en los productos

        // Crear la consulta HQL para seleccionar todas las categorías
        org.hibernate.query.Query<Categoria> query1
                = session.createQuery("FROM Categoria c WHERE c.pkcategoria = :pkcategoria", Categoria.class);
        query1.setParameter("pkcategoria", i);
        Categoria cat = query1.getSingleResult();

        // Crear la consulta HQL para seleccionar los productos
        org.hibernate.query.Query<Producto> query
                = session.createQuery("FROM Producto p WHERE p.fkcategoria = :fkcategoria", Producto.class);
        query.setParameter("fkcategoria", cat);

        // Obtener la lista de resultados
        List<Producto> lista = query.getResultList();

        // Imprimir los resultados
        for (Producto a : lista) {
            System.out.println(a.getFkcategoria().getNombre() + "   " + a.getNombre());
        }
        System.out.println("");
    }
}
