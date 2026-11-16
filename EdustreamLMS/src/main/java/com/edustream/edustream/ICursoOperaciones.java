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
public interface ICursoOperaciones {
    boolean registrarCurso(Curso curso);
    ArrayList<Curso> listarCursos();
    Curso buscarCursoPorId(int idCurso);
}
