/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maikel
 */
package com.edustream.edustream;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {

    public boolean registrarCurso(Curso curso) {

        String sql = "INSERT INTO cursos "
                + "(nombre_curso, descripcion, id_profesor) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, curso.getNombreCurso());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getIdProfesor());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar curso: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Curso> listarCursos() {

        ArrayList<Curso> lista = new ArrayList<>();

        String sql = "SELECT * FROM cursos";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Curso curso = new Curso();

                curso.setIdCurso(rs.getInt("id_curso"));
                curso.setNombreCurso(rs.getString("nombre_curso"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setIdProfesor(rs.getInt("id_profesor"));

                lista.add(curso);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
        }

        return lista;
    }
}
