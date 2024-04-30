package org.example.domain;

public class Abonos {

    private Fecha fechaAbono;

    private Float montoAbono;


    public Abonos(Fecha fechaAbono, Float montoAbono) {
        this.fechaAbono = fechaAbono;
        this.montoAbono = montoAbono;
    }

    public Fecha getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Fecha fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public Float getMontoAbono() {
        return montoAbono;
    }

    public void setMontoAbono(Float montoAbono) {
        this.montoAbono = montoAbono;
    }

    @Override
    public String toString() {
        return "Abonos{" +
                "fechaAbono=" + fechaAbono +
                ", montoAbono=" + montoAbono +
                '}';
    }
}
