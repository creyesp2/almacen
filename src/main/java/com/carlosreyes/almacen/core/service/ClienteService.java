package com.carlosreyes.almacen.core.service;

import com.carlosreyes.almacen.core.model.Cliente;
import java.util.List;

public interface ClienteService {
    public List<Cliente> findAllCliente();
    public Cliente findByNit(String nitCliente);
    public void saveCliente(Cliente elemento);
    public void deleteCliente(Cliente elemento);
    public void updateCliente(Cliente elemento);
}
