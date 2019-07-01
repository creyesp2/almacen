package com.carlosreyes.almacen.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="detalle_factura")
public class DetalleFactura implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo_detalle")
    private Long codigoDetalle;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numero_factura")
    private Factura numeroFactura;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_producto")
    private Producto codigoProducto;
    
    @Column(name="cantidad")
    private Long cantidad;
    
    @Column(name="precio")
    private Float precio;
    
    @Column(name="descuento")
    private Long descuento;

    public DetalleFactura() {
    }

    public DetalleFactura(Long codigoDetalle, Factura numeroFactura, Producto codigoProducto, Long cantidad, Float precio, Long descuento) {
        this.codigoDetalle = codigoDetalle;
        this.numeroFactura = numeroFactura;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Long getCodigoDetalle() {
        return codigoDetalle;
    }

    public void setCodigoDetalle(Long codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public Factura getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Factura numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Producto getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Producto codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Long getDescuento() {
        return descuento;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }
    
    
}
