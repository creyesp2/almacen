package com.carlosreyes.almacen.core.service;

import com.carlosreyes.almacen.core.dao.FacturaDao;
import com.carlosreyes.almacen.core.dao.FacturaDaoImpl;
import com.carlosreyes.almacen.core.model.Factura;
import java.util.List;

public class FacturaServiceImpl implements FacturaService{

        private FacturaDao facturaDao = new FacturaDaoImpl();

    @Override
    public List<Factura> findAllFactura() {
        return facturaDao.findAllFactura();
    }

    @Override
    public Factura findById(Long numeroFactura) {
        return facturaDao.findByNumeroFactura(numeroFactura);
    }

    @Override
    public void saveFactura(Factura elemento) {
        facturaDao.saveFactura(elemento);
    }

    @Override
    public void deleteFactura(Factura elemento) {
        facturaDao.deleteFactura(elemento);
    }

    @Override
    public void updateFactura(Factura elemento) {
        facturaDao.updateFactura(elemento);
    }
    
}
