package org.example.domain;


import org.example.base.Cliente;
import org.example.enums.TipoCliente;

public class ClientePersonaNatural extends Cliente {

    public ClientePersonaNatural(String nombre, String apellido, String documento) {
        super(nombre, apellido, documento, TipoCliente.PERSONA_NATURAL);
    }


    public String toString() {
        return "ClientePersonaNatural [id=" + getId() + ", nombre="
                + getNombre() + ", apellido=" + getApellido() + ", documento=" + getDocumento() + " + tipoCliente=" + getTipoCliente() + "]";
    }


}
