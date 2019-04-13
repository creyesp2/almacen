/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosreyes.almacen.core.service;

import com.carlosreyes.almacen.core.dao.ProveedorDao;
import com.carlosreyes.almacen.core.dao.ProveedorDaoImpl;
import com.carlosreyes.almacen.core.model.Proveedor;
import java.util.List;

/**
 *
 * @author programacion
 */
public class ProveedorServiceImpl implements ProveedoService {

    private ProveedorDao proveedorDao = new ProveedorDaoImpl();

    @Override
    public List<Proveedor> findAllProveedor() {
        return proveedorDao.findAllProveedor();
    }

    @Override
    public Proveedor findById(Long codigoProveedor) {
        return proveedorDao.findById(codigoProveedor);
    }

    @Override
    public void saveProveedor(Proveedor elemento) {
        proveedorDao.saveProveedor(elemento);
    }

    @Override
    public void deleteProveedor(Proveedor elemento) {
        proveedorDao.deleteProveedor(elemento);
    }

    @Override
    public void updateProveedor(Proveedor elemento) {
        proveedorDao.updateProveedor(elemento);
    }

}
