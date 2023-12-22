/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Yo
 */
public class ThirdController implements Initializable {

    @FXML
    private AnchorPane anchorPane1;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane anchorPane2;
    @FXML
    private TilePane tilePane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 

        for (int i = 0; i < 300; i++) {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("primary.fxml"));
            try {
                VBox vBox = loader.load();

                tilePane.getChildren().add(vBox);

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}
