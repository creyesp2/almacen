package com.carlosreyes.almacen.core.controller;

import com.carlosreyes.almacen.core.sistema.Principal;
import com.carlosreyes.almacen.core.model.Categoria;
import com.carlosreyes.almacen.core.service.CategoriaService;
import com.carlosreyes.almacen.core.service.CategoriaServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class CategoriaController implements Initializable {

    private Principal principal;
    private CategoriaService categoriaService = new CategoriaServiceImpl();
 

    @FXML
    private TableView<Categoria> tblCategoria;
    
    @FXML
    private TableColumn<Categoria, Number> colCodigoCategoria;
    
    @FXML
    private TableColumn<Categoria, String> colDescripcion;
    
    @FXML private TextField txtDescripcion;
    
     @FXML
    private Button btnNuevo;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnReporte;
    @FXML
    private Button btnSalir;

     private ObservableList<Categoria> lista;
     private enum tipo {NUEVO,CANCELAR,GUARDAR,NINGUNO,MODIFICAR}
    private tipo tipoOperacion = tipo.NINGUNO;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(categoriaService.findAllCategoria());
        this.tblCategoria.setItems(lista);
        
        this.colCodigoCategoria.setCellValueFactory(cellData -> cellData.getValue().codigoCategoria());
        this.colDescripcion.setCellValueFactory(cellData -> cellData.getValue().descripcion());
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public void regresarVentanaPrincipal() throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }
    
    public void nuevo(){
        switch(tipoOperacion){
            case NINGUNO:
                this.activarDesactivarControles(true);
         
                this.limpiar();
                this.btnNuevo.setText("Cancelar");
                this.btnGuardar.setDisable(false);
                this.btnEliminar.setDisable(true);
                this.btnModificar.setDisable(true);
                this.btnReporte.setDisable(true);
                this.btnSalir.setDisable(true);
                this.tipoOperacion = CategoriaController.tipo.NUEVO;
                break;
            case NUEVO:
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = CategoriaController.tipo.NINGUNO;
                break;
            case MODIFICAR:
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = CategoriaController.tipo.NINGUNO;
                break;
        }
    }

    public void modificar(){
        if(this.tblCategoria.getSelectionModel().getSelectedItem() != null){
            this.activarDesactivarControles(true);
            this.tipoOperacion = CategoriaController.tipo.MODIFICAR;
            this.btnNuevo.setText("Cancelar");
            this.btnGuardar.setDisable(false);
            this.btnEliminar.setDisable(true);
            this.btnModificar.setDisable(true);
            this.btnReporte.setDisable(true);
            this.btnSalir.setDisable(true);
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar un registro");
        }
    }
    
    public void seleccionar(){
      txtDescripcion.setText(tblCategoria.getSelectionModel().getSelectedItem().getDescripcion());   
     
      
    }
    public void activarDesactivarControles(boolean tipo){
        this.txtDescripcion.setEditable(tipo);
        
        
    }
    public void limpiar(){
        this.txtDescripcion.setText("");
       
        
    }
    
    public void salir() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    public void eliminar(){
        if(this.tblCategoria.getSelectionModel().getSelectedItem() != null){
            
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "Esta seguro de eliminar el registro?",
                    "Eliminar",JOptionPane.YES_NO_OPTION);
            
            if(JOptionPane.YES_OPTION == respuesta){
                int index = this.tblCategoria.getSelectionModel().getSelectedIndex();
                Categoria elemento = this.tblCategoria.getSelectionModel().getSelectedItem();                
                this.categoriaService.deleteCategoria(elemento);
                this.lista.remove(index);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar una elemento!!!");            
        }
    }
    public void guardar(){
        switch(tipoOperacion){
            case NUEVO:
                Categoria nuevo = new Categoria();
                nuevo.setDescripcion(txtDescripcion.getText());
               
                this.categoriaService.saveCategoria(nuevo);
                this.lista.add(nuevo);
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                JOptionPane.showMessageDialog(null,"Registro almacenado");
                this.activarDesactivarControles(false);
                break;
            case MODIFICAR:
                Categoria categoria = tblCategoria.getSelectionModel().getSelectedItem();       
                categoria.setDescripcion(txtDescripcion.getText());
               
                
                this.categoriaService.updateCategoria(categoria);
                lista.set(tblCategoria.getSelectionModel().getSelectedIndex(),categoria);
                JOptionPane.showMessageDialog(null,"Registro actualizado!!!");
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.activarDesactivarControles(false);
                break;
        }
        this.tipoOperacion = CategoriaController.tipo.NINGUNO;
    }

}
