package com.edustream.edustream;

import java.util.ArrayList;

public interface ICursoOperaciones {
    boolean registrarCurso(Curso curso);
    ArrayList<Curso> listarCursos();
    Curso buscarCursoPorId(int idCurso);
}