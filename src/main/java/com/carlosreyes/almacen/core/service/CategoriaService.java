/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosreyes.almacen.core.service;

import com.carlosreyes.almacen.core.model.Categoria;
import java.util.List;

/**
 *
 * @author cmayen
 */
public interface CategoriaService {
    public List<Categoria> findAllCategoria();
    public Categoria findById(Long codigoCategoria);
    public void saveCategoria(Categoria elemento);
    public void deleteCategoria(Categoria elemento);
    public void updateCategoria(Categoria elemento);
}
