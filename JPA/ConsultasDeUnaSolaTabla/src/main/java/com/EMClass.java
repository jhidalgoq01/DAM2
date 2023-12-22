/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Yo
 */
public class EMClass {

    public static EntityManager EM;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com_Prueba1JPA_jar_1.0-SNAPSHOTPU");

        EM = emf.createEntityManager();
    }

}
