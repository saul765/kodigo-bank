package org.example.repository;


import org.example.base.Cliente;

import java.util.ArrayList;

public class ClienteRepositoryImpl implements IClienteRepository {

    private final ArrayList<Cliente> clientes;

    public ClienteRepositoryImpl(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public Cliente getCliente(String numeroDocumento) {
        return clientes.stream()
                .filter(cliente -> cliente.getDocumento().equals(numeroDocumento))
                .findFirst()
                .orElse(null);
    }


}
