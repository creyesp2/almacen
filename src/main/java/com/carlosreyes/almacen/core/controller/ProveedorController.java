/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosreyes.almacen.core.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import com.creyes.almacem.almacen.core.sistema.Principal;
import java.io.IOException;
/**
 *
 * @author programacion
 */
public class ProveedorController implements Initializable {
    private Principal principal;
    
      @FXML private TableView tblProveedor;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    }
    public void setPrincipal(Principal ventanaPrincipal){
    this.principal=principal;
    }
    public void regresaVentanaPrincipal()throws IOException{
    this.principal.mostrarVentanaPricipal();
    
    }
}
