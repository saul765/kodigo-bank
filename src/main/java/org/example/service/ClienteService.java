package org.example.service;


import org.example.base.Cliente;
import org.example.repository.IClienteRepository;

public class ClienteService implements IClienteService {

    private final IClienteRepository clienteRepository;


    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente getCliente(String numeroDocumento) {
        return clienteRepository.getCliente(numeroDocumento);
    }

}
