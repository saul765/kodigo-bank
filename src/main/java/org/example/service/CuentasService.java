package org.example.service;



import org.example.base.Cuenta;
import org.example.domain.Abonos;
import org.example.domain.Fecha;
import org.example.repository.ICuentasRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CuentasService implements ICuentasService {

    ICuentasRepository cuentasRepository;

    public CuentasService(ICuentasRepository cuentasRepository) {
        this.cuentasRepository = cuentasRepository;
    }

    public Float consultarSaldo(Integer numeroCuenta) {
        return cuentasRepository.consultarSaldo(numeroCuenta);
    }

    public void abonar(Integer numeroCuenta, Float monto) {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Abonos abono = new Abonos(buildFechaAbono(), monto);
        cuentasRepository.abonar(numeroCuenta, abono);
    }

    public List<Abonos> getHistorialAbonos(Integer numeroCuenta) {
        return cuentasRepository.getHistorialAbonos(numeroCuenta);
    }

    @Override
    public List<Cuenta> getCuentasByClienteId(Integer clienteId) {
        return cuentasRepository.getCuentasByClienteId(clienteId);
    }

    private Fecha buildFechaAbono() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return new Fecha(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }

}
