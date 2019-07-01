package com.carlosreyes.almacen.core.model;

import java.io.Serializable;
import javafx.beans.property.LongProperty;
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
@Table(name = "tipo_empaque")
@NamedQueries(
    {
        @NamedQuery(name="TipoDeEmpaque.findAll", query="select t from TipoDeEmpaque t"),
        @NamedQuery(name="TipoDeEmpaque.findAllOrderById", query = "select t from TipoDeEmpaque t order by t.codigoEmpaque"),
        @NamedQuery(name="TipoDeEmpaque.findByCodigoTipoDeEmpaque", query = "select t from TipoDeEmpaque t where t.codigoEmpaque = ?1")
    }
)
public class TipoDeEmpaque implements Serializable {

    
    private final LongProperty codigoEmpaque;
    private final StringProperty descripcion;

    public TipoDeEmpaque() {
        this.codigoEmpaque = new SimpleLongProperty();
        this.descripcion = new SimpleStringProperty();
    }

    public TipoDeEmpaque(Long codigoEmpaque, String descripcion) {
        this.codigoEmpaque = new SimpleLongProperty(codigoEmpaque);
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empaque")
    public Long getCodigoEmpaque() {
        return codigoEmpaque.get();
    }

    public void setCodigoEmpaque(Long codigoEmpaque) {
        this.codigoEmpaque.set(codigoEmpaque);
    }

    public LongProperty codigoEmpaque(){
        return this.codigoEmpaque;
    }
    
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }
    
    public StringProperty descripcion(){
        return this.descripcion;
    }
    
    
}
