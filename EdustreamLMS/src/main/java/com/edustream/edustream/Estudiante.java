package com.edustream.edustream;

public class Estudiante extends Usuario {

    private String carne;

    public Estudiante() {
        super();
        setRol("ESTUDIANTE");
    }

    public Estudiante(int idUsuario, String nombre, String correo, String carne) {
        super(idUsuario, nombre, correo, "ESTUDIANTE");
        this.carne = carne;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }
}