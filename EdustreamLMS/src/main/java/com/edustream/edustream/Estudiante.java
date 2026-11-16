/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edustream.edustream;

/**
 *
 * @author toty1
 */
public class Estudiante extends Usuario {
    private String carnet;

    public Estudiante() {
        super();
        this.rol = "ESTUDIANTE";
    }

    public Estudiante(int id, String nombre, String email, String password, String carnet) {
        super(id, nombre, email, password, "ESTUDIANTE");
        this.carnet = carnet;
    }

    @Override
    public String obtenerTipoUsuario() {
        return "ESTUDIANTE";
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
}
