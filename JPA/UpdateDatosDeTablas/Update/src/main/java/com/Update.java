/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Yo
 */
public class Update {

    static EntityManager em = EMClass.EM;

    public static void main(String[] args) {
        updateTableCategoriaElNombre("Categoria 3", 200);
        updateTableCategoriaElPK();
    }

    public static void updateTableCategoriaElNombre(String nombreNuevo, Integer pkcategoria) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Query query = em.createNativeQuery("UPDATE Categoria SET nombre = :nombre WHERE pkcategoria = :pkcategoria");
            query.setParameter("nombre", nombreNuevo);
            query.setParameter("pkcategoria", pkcategoria);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {

        }

    }

    public static void updateTableCategoriaElPK() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Query query
                    = em.createNativeQuery("UPDATE Producto SET fkcategoria = :newfkcategoria WHERE fkcategoria = :fkcategoria");
            query.setParameter("newfkcategoria", 200);
            query.setParameter("fkcategoria", 100);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }
}
