/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module Pueba1JPA {
    requires mysql.connector.j;
    requires com.google.protobuf;
    requires org.hibernate.orm.core;
    requires org.jboss.logging;
    requires java.persistence;
    requires net.bytebuddy;
    requires antlr;
    requires java.transaction;
    requires org.jboss.jandex;
    requires com.fasterxml.classmate;
    requires java.activation;
    requires org.hibernate.commons.annotations;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.sun.xml.txw2;
    requires com.sun.istack.runtime;
    requires org.jvnet.staxex;
    requires com.sun.xml.fastinfoset;
    requires hibernate.entitymanager;
    
    opens com.pueba1jpa;
    opens entities;
    
}
