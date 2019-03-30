/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosreyes.almacen.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
/**
 *
 * @author programacion
 */
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//solo primary key autoincrementable
    @Column(name = "codigo_proveedor")
    private Long codigoProveedor;

    @Column(name = "nit")
    private String nit;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "pagina_web")
    private String paginaWeb;
    @Column(name = "contacto_principal")
    private String contactoPrincipal;

    public Proveedor() {
    }

    public Proveedor(Long codigoProveedor, String nit, String razonSocial, String direccion, String paginaWeb, String contactoPrincipal) {
        this.codigoProveedor = codigoProveedor;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.paginaWeb = paginaWeb;
        this.contactoPrincipal = contactoPrincipal;
    }

    public Long getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Long codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getContactoPrincipal() {
        return contactoPrincipal;
    }

    public void setContactoPrincipal(String contactoPrincipal) {
        this.contactoPrincipal = contactoPrincipal;
    }

}
