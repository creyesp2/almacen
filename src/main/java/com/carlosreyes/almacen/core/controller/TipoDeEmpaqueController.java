package com.carlosreyes.almacen.core.controller;

import com.carlosreyes.almacen.core.sistema.Principal;
import com.carlosreyes.almacen.core.model.TipoDeEmpaque;
import com.carlosreyes.almacen.core.service.TipoDeEmpaqueService;
import com.carlosreyes.almacen.core.service.TipoDeEmpaqueServiceImpl;
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

public class TipoDeEmpaqueController implements Initializable {

    private Principal principal;
    private TipoDeEmpaqueService tipoDeEmpaqueService = new TipoDeEmpaqueServiceImpl();

    @FXML
    private TableView<TipoDeEmpaque> tblTipoDeEmpaque;

    @FXML
    private TableColumn<TipoDeEmpaque, Number> colCodigoTipoDeEmpaque;

    @FXML
    private TableColumn<TipoDeEmpaque, String> colDescripcion;
    
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
    
    private ObservableList<TipoDeEmpaque> lista;
     private enum tipo {NUEVO,CANCELAR,GUARDAR,NINGUNO,MODIFICAR}
    private tipo tipoOperacion = tipo.NINGUNO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(tipoDeEmpaqueService.findAllTipoDeEmpaque());
        this.tblTipoDeEmpaque.setItems(lista);
        
        this.colCodigoTipoDeEmpaque.setCellValueFactory(cellData -> cellData.getValue().codigoEmpaque());
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
                this.tipoOperacion = TipoDeEmpaqueController.tipo.NUEVO;
                break;
            case NUEVO:
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = TipoDeEmpaqueController.tipo.NINGUNO;
                break;
            case MODIFICAR:
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = TipoDeEmpaqueController.tipo.NINGUNO;
                break;
        }
    }

    public void modificar(){
        if(this.tblTipoDeEmpaque.getSelectionModel().getSelectedItem() != null){
            this.activarDesactivarControles(true);
            this.tipoOperacion = TipoDeEmpaqueController.tipo.MODIFICAR;
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
      txtDescripcion.setText(tblTipoDeEmpaque.getSelectionModel().getSelectedItem().getDescripcion());   
     
      
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
        if(this.tblTipoDeEmpaque.getSelectionModel().getSelectedItem() != null){
            
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "Esta seguro de eliminar el registro?",
                    "Eliminar",JOptionPane.YES_NO_OPTION);
            
            if(JOptionPane.YES_OPTION == respuesta){
                int index = this.tblTipoDeEmpaque.getSelectionModel().getSelectedIndex();
                TipoDeEmpaque elemento = this.tblTipoDeEmpaque.getSelectionModel().getSelectedItem();                
                this.tipoDeEmpaqueService.deleteTipoDeEmpaque(elemento);
                this.lista.remove(index);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar una elemento!!!");            
        }
    }
    public void guardar(){
        switch(tipoOperacion){
            case NUEVO:
                TipoDeEmpaque nuevo = new TipoDeEmpaque();
                nuevo.setDescripcion(txtDescripcion.getText());
               
                this.tipoDeEmpaqueService.saveTipoDeEmpaque(nuevo);
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
                TipoDeEmpaque cliente = tblTipoDeEmpaque.getSelectionModel().getSelectedItem();       
                cliente.setDescripcion(txtDescripcion.getText());
               
                
                this.tipoDeEmpaqueService.updateTipoDeEmpaque(cliente);
                lista.set(tblTipoDeEmpaque.getSelectionModel().getSelectedIndex(),cliente);
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
        this.tipoOperacion = TipoDeEmpaqueController.tipo.NINGUNO;
    }
    
}
