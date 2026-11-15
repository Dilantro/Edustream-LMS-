/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maike
 */
package com.edustream.edustream;

import com.edustream.edustream.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InscripcionDAO {

    public boolean registrarInscripcion(int idEstudiante, int idCurso)
            throws SQLException, InscripcionDuplicadaException {

        String consulta = "SELECT * FROM inscripciones "
                + "WHERE id_estudiante = ? AND id_curso = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(consulta)) {

            ps.setInt(1, idEstudiante);
            ps.setInt(2, idCurso);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                throw new InscripcionDuplicadaException(
                        "El estudiante ya esta inscrito en este curso."
                );
            }
        }

        String sql = "INSERT INTO inscripciones "
                + "(id_estudiante, id_curso, fecha_inscripcion) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idEstudiante);
            ps.setInt(2, idCurso);
            ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));

            ps.executeUpdate();

            return true;
        }
    }

    public ArrayList<Integer> listarPorEstudiante(int idEstudiante) {

        ArrayList<Integer> lista = new ArrayList<>();

        String sql = "SELECT id_curso FROM inscripciones "
                + "WHERE id_estudiante = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idEstudiante);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(rs.getInt("id_curso"));
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar inscripciones: "
                    + e.getMessage());
        }

        return lista;
    }
}