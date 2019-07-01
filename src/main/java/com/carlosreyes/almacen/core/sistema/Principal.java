package com.carlosreyes.almacen.core.sistema;

import com.carlosreyes.almacen.core.controller.CategoriaController;
import com.carlosreyes.almacen.core.controller.ClienteController;
import com.carlosreyes.almacen.core.controller.ProveedorController;
import com.carlosreyes.almacen.core.controller.ProveedorController;
import com.carlosreyes.almacen.core.controller.TipoDeEmpaqueController;
import com.carlosreyes.almacen.core.controller.VentanaPrincipalController;
import com.carlosreyes.almacen.core.controller.VentanaPrincipalController;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Principal extends Application {
    private final String PAQUETE_VISTA = "/com/carlosreyes/almacen/core/view/";
    private Stage escenarioPrincipal;
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal;
         mostrarVentanaPrincipal();        
        //mostrarVentanaProveedores();
        this.escenarioPrincipal.setTitle("Sistema de control de Almacen V. 1.0");
        this.escenarioPrincipal.show();
    }
    
    public void mostrarVentanaPrincipal() throws IOException{
        VentanaPrincipalController main = (VentanaPrincipalController)cambiarEscena("VentanaPrincipalView.fxml",800,600);
        main.setPrincipal(this);
    }
    
    public void mostrarVentanaProveedores() throws IOException{
        ProveedorController proveedorController = 
                (ProveedorController)cambiarEscena("ProveedorView.fxml",602,458);
        proveedorController.setPrincipal(this);
    }
    
     public void mostrarVentanaClientes() throws IOException {
        ClienteController clienteController = (ClienteController) cambiarEscena("ClienteView.fxml",762,573);
        clienteController.setPrincipal(this);
    }
     
     public void mostrarVentanaTipoEmpaque()throws IOException{
     TipoDeEmpaqueController tipoDeEmpaqueController=(TipoDeEmpaqueController)cambiarEscena("TipoDeEmpaqueView.fxml",762,573);
     tipoDeEmpaqueController.setPrincipal(this);
     }
       
     public void mostrarVentanaCategoria()throws IOException{
     CategoriaController categoriaController=(CategoriaController)cambiarEscena("TipoDeEmpaqueView.fxml",762,573);
     categoriaController.setPrincipal(this);
     }
       
    public Initializable cambiarEscena(String fxml, int ancho, int alto) 
            throws IOException{        
        Initializable resultado = null;
        //Cargador del archivo FXML
        FXMLLoader cargadorFXML = new FXMLLoader();
        //Asignacion del archivo logico
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA + fxml);                
        //Cargdor de fabrica para cargar el archivo FXML
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());        
        //Direccion de la ruta del archivo FXML
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA + fxml));        
        //Creacion de la escena
        Scene escena = new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto);         
        //Asignacion de la escena en el escenario principal
        this.escenarioPrincipal.setScene(escena);
        //Ajustar el tamaño del escenario a la escena
        this.escenarioPrincipal.sizeToScene();
        //Retornar el objeto initializable del controlador
        resultado = (Initializable)cargadorFXML.getController();
        return resultado;
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

}
