/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edustream.edustream;

/**
 *
 * @author toty1
 */
public class Profesor extends Usuario {
    private String especialidad;

    public Profesor() {
        super();
        this.rol = "PROFESOR";
    }

    public Profesor(int id, String nombre, String email, String password, String especialidad) {
        super(id, nombre, email, password, "PROFESOR");
        this.especialidad = especialidad;
    }

    @Override
    public String obtenerTipoUsuario() {
        return "PROFESOR";
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
