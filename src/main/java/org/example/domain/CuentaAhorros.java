package org.example.domain;


import org.example.base.Cliente;
import org.example.base.Cuenta;

public class CuentaAhorros extends Cuenta {


    public CuentaAhorros(Cliente cliente) {
        super(cliente);
    }

    public CuentaAhorros(Cliente cliente, Float saldo) {
        super(cliente, saldo);
    }


}
