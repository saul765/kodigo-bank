package org.example.service;



import org.example.base.Cuenta;
import org.example.domain.Abonos;

import java.util.List;

public interface ICuentasService {


    Float consultarSaldo(Integer numeroCuenta);

    void abonar(Integer numeroCuenta, Float monto);

    List<Abonos> getHistorialAbonos(Integer numeroCuenta);

    List<Cuenta> getCuentasByClienteId(Integer clienteId);
}
