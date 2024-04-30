package org.example.base;


import org.example.enums.TipoCliente;
import org.example.sequence.ClienteIdGenerator;

public abstract class Cliente extends Persona {

    private String documento;

    private TipoCliente tipoCliente;

    public Cliente(String nombre, String apellido, String documento, TipoCliente tipoCliente) {
        super(ClienteIdGenerator.getNextId(), nombre, apellido);
        this.documento = documento;
        this.tipoCliente = tipoCliente;
    }

    public String getDocumento() {
        return documento;
    }

    protected void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    protected void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento='" + documento + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}
