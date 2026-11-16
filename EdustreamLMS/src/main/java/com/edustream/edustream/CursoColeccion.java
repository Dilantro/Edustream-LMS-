/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edustream.edustream;

import java.util.ArrayList;

/**
 *
 * @author toty1
 */
public class CursoColeccion implements ICursoOperaciones {
    private ArrayList<Curso> listaCursos;

    public CursoColeccion() {
        this.listaCursos = new ArrayList<>();
    }

    @Override
    public boolean registrarCurso(Curso curso) {
        return listaCursos.add(curso);
    }

    @Override
    public ArrayList<Curso> listarCursos() {
        return listaCursos;
    }

    @Override
    public Curso buscarCursoPorId(int idCurso) {
        for (Curso c : listaCursos) {
            if (c.getIdCurso() == idCurso) {
                return c;
            }
        }
        return null;
    }
}
