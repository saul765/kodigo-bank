package org.example.domain;


import org.example.base.Cliente;
import org.example.enums.TipoCliente;

public class ClientePersonaJuridica extends Cliente {


    public ClientePersonaJuridica(String nombre, String apellido, String documento) {
        super(nombre, apellido, documento, TipoCliente.PERSONA_JURIDICA);
    }


    @Override
    public String toString() {
        return "ClientePersonaJuridica [id=" + getId() + ", nombre=" + getNombre() + ", apellido=" + getApellido() + ", documento=" + getDocumento() + " + tipoCliente=" + getTipoCliente() + "]";
    }
}
