package com.carlosreyes.almacen.core.model;

import java.io.Serializable;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@NamedQueries(
        {
        @NamedQuery(name="Cliente.findAll",query="select c from Cliente c")
        }

)
public class Cliente implements Serializable {
    
    
    
    private final StringProperty nit;
    
   
    private final  StringProperty dpi;
    
   
    private final StringProperty nombre;
    
   
    private  final StringProperty direccion;

    public Cliente() {
         
        this.nit = new SimpleStringProperty();
        this.dpi= new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.direccion= new SimpleStringProperty();
       

    }

    public Cliente(String nit, String dpi, String nombre, String direccion) {
     this.nit = new SimpleStringProperty(nit);
        this.dpi = new SimpleStringProperty(dpi);
        this.nombre = new SimpleStringProperty(nombre);
        this.direccion = new SimpleStringProperty(direccion);
    }

    @Id
     //@GeneratedValue(strategy = GenerationType.IDENTITY)//solo primary key autoincrementable
    @Column(name="nit")
    public String getNit() {
        return nit.getValue();
    }
 public void setNit(String nit) {
        this.nit.set(nit);
    }
    
    public StringProperty nit(){
        return this.nit;
    }
    
    
 @Column(name="dpi")
    public String getDpi() {
        return dpi.get();
    }

    public void setDpi(String dpi) {
        this.dpi.set(dpi);
    }
    
     public StringProperty dpi(){
        return this.dpi;
    }
    
     @Column(name="nombre")
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    
     public StringProperty nombre(){
        return this.nombre;
    }
    
    @Column(name="direccion")
    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }
    
    public StringProperty direccion(){
        return this.direccion;
    }
    
}
