package com.edustream.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InscripcionServlet", urlPatterns = {"/InscripcionServlet", "/inscripciones"})
public class InscripcionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // TODO: Consultar inscripciones o cursos disponibles desde la capa de datos/lógica:
        // request.setAttribute("listaInscripciones", inscripcionDAO.listarInscripciones());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/inscripciones.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession sesion = request.getSession(false);
        if (sesion == null || sesion.getAttribute("usuarioCorreo") == null) {
            request.setAttribute("error", "Debes iniciar sesión para inscribirte a un curso.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        String idCursoParam = request.getParameter("idCurso");
        if (idCursoParam == null || idCursoParam.isBlank()) {
            request.setAttribute("error", "Debes seleccionar un curso válido.");
            request.getRequestDispatcher("/inscripciones.jsp").forward(request, response);
            return;
        }

        try {
            int idCurso = Integer.parseInt(idCursoParam.trim());

            // TODO: Validar curso y registrar inscripción cuando estén en el repo:
            // Curso curso = cursoDAO.buscarCursoPorId(idCurso);
            // boolean inscrito = inscripcionDAO.registrarInscripcion(...);

            response.sendRedirect(request.getContextPath() + "/InscripcionServlet?mensaje=inscrito&idCurso=" + idCurso);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "El identificador del curso no es válido.");
            request.getRequestDispatcher("/inscripciones.jsp").forward(request, response);
        }
    }
}