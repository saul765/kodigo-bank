package org.example.base;

public abstract class Persona {

    private Integer id;

    private String nombre;

    private String apellido;


    public Persona(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    protected void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
