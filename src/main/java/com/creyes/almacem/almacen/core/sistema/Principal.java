 package com.creyes.almacem.almacen.core.sistema;

import com.carlosreyes.almacen.core.controller.ProveedorController;
import com.carlosreyes.almacen.core.controller.VentanaPrincipalController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Principal extends Application {
private final String PAQUETE_VISTA = "/com/carlosreyes/almacen/core/view/";
private Stage escenarioPrincipal;
    @Override
    public void start(Stage ecenarioPrincipal) throws Exception {
        this.escenarioPrincipal =ecenarioPrincipal;
       //mostrarVentanaPricipal();
       mostrarVentanaProveedores();
        this.escenarioPrincipal.setTitle("SISTEMA DE CONTROL DE ALMACEN");
        this.escenarioPrincipal.show();
        
 
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void mostrarVentanaPricipal() throws IOException{
    VentanaPrincipalController main = (VentanaPrincipalController)cambiarEscena("VentanaPrincipalView.fxml",800,600);
    main.setPrincipal(this);
    }
    public void mostrarVentanaProveedores() throws IOException{
    
    ProveedorController proveedorController =(ProveedorController)cambiarEscena("Proveedorview.fxml",600,400);
    proveedorController.setPrincipal(this);
    }
    
public Initializable cambiarEscena(String fxml, int  ancho, int alto )throws IOException{
Initializable resultado = null;
 
    FXMLLoader loader = new FXMLLoader();
    Parent root = loader.load(getClass().getResource(PAQUETE_VISTA + fxml));
    Scene escena = new Scene(root,ancho,alto);
    escena.getStylesheets().add("/styles/Styles.css");
    this.escenarioPrincipal.setScene(escena);
    this.escenarioPrincipal.sizeToScene();
    resultado = (Initializable)loader.getController();
    return  resultado;
}
}
