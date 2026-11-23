package com.edustream.edustream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public boolean registrarCurso(Curso curso) {
        String sql = "INSERT INTO cursos (nombre_curso, descripcion, id_profesor) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, curso.getNombreCurso());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getIdProfesor());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar curso: " + e.getMessage());
            return false;
        }
    }

    public List<Curso> listarCursos() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT id_curso, nombre_curso, descripcion, id_profesor FROM cursos";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Curso c = new Curso(
                    rs.getInt("id_curso"),
                    rs.getString("nombre_curso"),
                    rs.getString("descripcion"),
                    rs.getInt("id_profesor")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
        }
        return lista;
    }

    public Curso buscarPorId(int idCurso) {
        String sql = "SELECT id_curso, nombre_curso, descripcion, id_profesor FROM cursos WHERE id_curso = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCurso);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Curso(
                        rs.getInt("id_curso"),
                        rs.getString("nombre_curso"),
                        rs.getString("descripcion"),
                        rs.getInt("id_profesor")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar curso: " + e.getMessage());
        }
        return null;
    }
}