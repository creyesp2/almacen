package com.carlosreyes.almacen.core.dao;

import com.carlosreyes.almacen.core.db.Conexion;
import com.carlosreyes.almacen.core.model.DetalleFactura;
import java.util.List;

public class DetalleFacturaDaoImpl implements DetalleFacturaDao{

    @Override
    public List<DetalleFactura> findAllDetalleFactura() {
        return (List<DetalleFactura>)Conexion.getInstancia().findAll(DetalleFactura.class);
    }

    @Override
    public DetalleFactura findByIdDetalle(Long idDetalle) {
        return (DetalleFactura)Conexion.getInstancia().findById(DetalleFactura.class, idDetalle);
    }

    @Override
    public void saveDetalleFactura(DetalleFactura elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteDetalleFactura(DetalleFactura elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateDetalleFactura(DetalleFactura elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
