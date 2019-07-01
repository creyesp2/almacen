package com.carlosreyes.almacen.core.dao;

import com.carlosreyes.almacen.core.model.Factura;
import java.util.List;

public interface FacturaDao {
    public List<Factura> findAllFactura();

    public Factura findByNumeroFactura(Long numeroFactura);

    public void saveFactura(Factura elemento);

    public void deleteFactura(Factura elemento);

    public void updateFactura(Factura elemento);
}
