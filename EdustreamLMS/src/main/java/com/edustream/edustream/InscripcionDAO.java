package com.edustream.edustream;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO {

    public boolean inscribir(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripciones (id_estudiante, id_curso, fecha_inscripcion) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, inscripcion.getIdEstudiante());
            ps.setInt(2, inscripcion.getIdCurso());
            LocalDate fecha = inscripcion.getFechaInscripcion() != null
                    ? inscripcion.getFechaInscripcion()
                    : LocalDate.now();
            ps.setDate(3, Date.valueOf(fecha));

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar inscripcion: " + e.getMessage());
            return false;
        }
    }

    public List<Inscripcion> listarInscripciones() {
        List<Inscripcion> lista = new ArrayList<>();
        String sql = "SELECT id_inscripcion, id_estudiante, id_curso, fecha_inscripcion FROM inscripciones";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Date fechaSql = rs.getDate("fecha_inscripcion");
                LocalDate fecha = fechaSql != null ? fechaSql.toLocalDate() : null;

                Inscripcion ins = new Inscripcion(
                    rs.getInt("id_inscripcion"),
                    rs.getInt("id_estudiante"),
                    rs.getInt("id_curso"),
                    fecha
                );
                lista.add(ins);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar inscripciones: " + e.getMessage());
        }
        return lista;
    }
}