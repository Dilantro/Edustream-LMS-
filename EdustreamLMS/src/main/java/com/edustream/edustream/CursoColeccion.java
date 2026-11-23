package com.edustream.edustream;

import java.util.ArrayList;
import java.util.List;

public class CursoColeccion {

    private final List<Curso> cursos = new ArrayList<>();

    public void agregarCurso(Curso curso) {
        if (curso != null) {
            cursos.add(curso);
        }
    }

    public List<Curso> obtenerCursos() {
        return new ArrayList<>(cursos);
    }
}