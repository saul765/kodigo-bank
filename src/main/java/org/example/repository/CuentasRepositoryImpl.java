package org.example.repository;



import org.example.base.Cuenta;
import org.example.domain.Abonos;

import java.util.ArrayList;
import java.util.List;

public class CuentasRepositoryImpl implements ICuentasRepository {

    private final ArrayList<Cuenta> cuentas;

    public CuentasRepositoryImpl(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public Float consultarSaldo(Integer numeroCuenta) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .map(Cuenta::getSaldo)
                .orElse(null);
    }

    @Override
    public void abonar(Integer numeroCuenta, Abonos monto) {
        cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .ifPresent(cuenta -> {
                    cuenta.setSaldo(cuenta.getSaldo() + monto.getMontoAbono());
                    cuenta.setAbonos(new ArrayList<>(List.of(monto)));
                });
    }


    @Override
    public List<Abonos> getHistorialAbonos(Integer numeroCuenta) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .map(Cuenta::getAbonos)
                .orElse(null);
    }

    @Override
    public List<Cuenta> getCuentasByClienteId(Integer clienteId) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getCliente().getId().equals(clienteId))
                .toList();
    }
}
