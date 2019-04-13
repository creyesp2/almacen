/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosreyes.almacen.core.dao;

import com.carlosreyes.alamcen.core.db.Conexion;
import com.carlosreyes.almacen.core.model.Proveedor;
import java.util.List;

/**
 *
 * @author programacion
 */
public class ProveedorDaoImpl implements ProveedorDao {

    @Override
    public List<Proveedor> findAllProveedor() {
      return (List<Proveedor>)Conexion.getInstancia().findAll(Proveedor.class);
    }

    @Override
    public Proveedor findById(Long codigoProveedor) {
        
        return(Proveedor)Conexion.getInstancia().findById(Proveedor.class,codigoProveedor);
    }

    @Override
    public void saveProveedor(Proveedor elemento) {
      Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteProveedor(Proveedor elemento) {
       Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateProveedor(Proveedor elemento) {
       Conexion.getInstancia().update(elemento);
    
}
}