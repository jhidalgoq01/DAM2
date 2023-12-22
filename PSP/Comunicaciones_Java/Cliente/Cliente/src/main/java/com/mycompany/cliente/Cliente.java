/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cliente;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Yo
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            // Conecta al servidor en el puerto 1234
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Conectado al servidor.");

            // Aquí puedes realizar cualquier lógica adicional para interactuar con el servidor
            // Cierra el socket del cliente
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
