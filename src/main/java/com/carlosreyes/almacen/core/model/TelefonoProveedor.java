package com.carlosreyes.almacen.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefono_proveedor")
public class TelefonoProveedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_telefono")
    private Long codigoTelefono;
    
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name="codigo_proveedor")
    private Proveedor proveedor;

    public TelefonoProveedor() {
    }

    public TelefonoProveedor(Long codigoTelefono, String numero, String descripcion, Proveedor proveedor) {
        this.codigoTelefono = codigoTelefono;
        this.numero = numero;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public Long getCodigoTelefono() {
        return codigoTelefono;
    }

    public void setCodigoTelefono(Long codigoTelefono) {
        this.codigoTelefono = codigoTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
