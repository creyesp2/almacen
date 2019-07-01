package com.carlosreyes.almacen.core.service;

import com.carlosreyes.almacen.core.model.TipoDeEmpaque;
import java.util.List;

public interface TipoDeEmpaqueService {
    public List<TipoDeEmpaque> findAllTipoDeEmpaque();
    public TipoDeEmpaque findById(Long codigoEmpaque);
    public void saveTipoDeEmpaque(TipoDeEmpaque elemento);
    public void deleteTipoDeEmpaque(TipoDeEmpaque elemento);
    public void updateTipoDeEmpaque(TipoDeEmpaque elemento);
}
