/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosreyes.almacen.core.service;

import com.carlosreyes.almacen.core.model.Proveedor;
import java.util.List;

/**
 *
 * @author programacion
 */
public interface ProveedorService {
     public List<Proveedor>findAllProveedor();
    public Proveedor findById(Long codigoProveedor);
    public void saveProveedor(Proveedor elemento);
    public void deleteProveedor(Proveedor elemento);
    public void updateProveedor(Proveedor elemento);
}
    
    
    

