package org.example.repository;


import org.example.base.Cuenta;
import org.example.domain.Abonos;

import java.util.List;

public interface ICuentasRepository {

    Float consultarSaldo(Integer numeroCuenta);

    void abonar(Integer numeroCuenta, Abonos monto);

    List<Abonos> getHistorialAbonos(Integer numeroCuenta);

    List<Cuenta> getCuentasByClienteId(Integer numeroCliente);
}
