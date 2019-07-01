package com.carlosreyes.almacen.core.dao;

import com.carlosreyes.almacen.core.db.Conexion;
import com.carlosreyes.almacen.core.model.TipoDeEmpaque;
import java.util.List;

public class TipoDeEmpaqueDaoImpl implements TipoDeEmpaqueDao{

    @Override
    public List<TipoDeEmpaque> findAllTipoDeEmpaque() {
        return (List<TipoDeEmpaque>)Conexion.getInstancia().findAll(TipoDeEmpaque.class);
    }

    @Override
    public TipoDeEmpaque findById(Long codigoEmpaque) {
        return (TipoDeEmpaque)Conexion.getInstancia().findById(TipoDeEmpaque.class, codigoEmpaque);
    }

    @Override
    public void saveTipoDeEmpaque(TipoDeEmpaque elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteTipoDeEmpaque(TipoDeEmpaque elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateTipoDeEmpaque(TipoDeEmpaque elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
