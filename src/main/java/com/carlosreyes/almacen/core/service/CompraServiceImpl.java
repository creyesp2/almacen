package com.carlosreyes.almacen.core.service;

import com.carlosreyes.almacen.core.dao.CompraDao;
import com.carlosreyes.almacen.core.dao.CompraDaoImpl;
import com.carlosreyes.almacen.core.model.Compra;
import java.util.List;

public class CompraServiceImpl implements CompraService {

    private CompraDao compraDao = new CompraDaoImpl();

    @Override
    public List<Compra> findAllCompra() {
        return compraDao.findAllCompra();
    }

    @Override
    public Compra findById(Long idCompra) {
        return compraDao.findById(idCompra);
    }

    @Override
    public void saveCompra(Compra elemento) {
        compraDao.saveCompra(elemento);
    }

    @Override
    public void deleteCompra(Compra elemento) {
        compraDao.deleteCompra(elemento);
    }

    @Override
    public void updateCompra(Compra elemento) {
        compraDao.updateCompra(elemento);
    }

}
