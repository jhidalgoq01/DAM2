/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author José Ramón Hidalgo
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            // Crea un socket de servidor en el puerto 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Servidor iniciado. Esperando conexiones...");

            // Espera a que un cliente se conecte
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress());

            // Aquí puedes realizar cualquier lógica adicional para interactuar con el cliente
            // Cierra el socket del cliente
            clientSocket.close();

            // Cierra el socket del servidor
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
