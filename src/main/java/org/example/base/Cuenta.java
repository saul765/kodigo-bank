package org.example.base;



import org.example.domain.Abonos;
import org.example.sequence.NumeroCuentaGenerator;

import java.util.ArrayList;

public abstract class Cuenta {

    private Integer numeroCuenta;

    private Cliente cliente;

    private ArrayList<Abonos> abonos;

    private Float saldo;

    public Cuenta(Cliente cliente) {
        this.numeroCuenta = NumeroCuentaGenerator.getNextId();
        this.cliente = cliente;
        this.abonos = new ArrayList<>();
    }

    public Cuenta(Cliente cliente, Float saldo) {
        this.numeroCuenta = NumeroCuentaGenerator.getNextId();
        this.cliente = cliente;
        this.saldo = saldo;
        this.abonos = new ArrayList<>();
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    protected void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Abonos> getAbonos() {
        return abonos;
    }

    public void setAbonos(ArrayList<Abonos> abonos) {
        this.abonos = abonos;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta=" + numeroCuenta +
                ", cliente=" + cliente +
                ", abonos=" + abonos +
                ", saldo=" + saldo +
                '}';
    }
}
