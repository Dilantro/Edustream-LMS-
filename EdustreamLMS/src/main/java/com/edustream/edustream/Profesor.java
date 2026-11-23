package com.edustream.edustream;

public class Profesor extends Usuario {

    private String especialidad;

    public Profesor() {
        super();
        setRol("PROFESOR");
    }

    public Profesor(int idUsuario, String nombre, String correo, String especialidad) {
        super(idUsuario, nombre, correo, "PROFESOR");
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}