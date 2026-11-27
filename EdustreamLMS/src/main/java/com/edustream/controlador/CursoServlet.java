package com.edustream.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet", "/cursos"})
public class CursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // TODO: Obtener lista de cursos desde la capa de datos/lógica cuando esté disponible:
        // request.setAttribute("listaCursos", cursoDAO.listarCursos());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/cursos.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession sesion = request.getSession(false);
        if (sesion == null || sesion.getAttribute("usuarioCorreo") == null) {
            request.setAttribute("error", "Debes iniciar sesión para gestionar cursos.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        String accion = request.getParameter("accion");
        String nombreCurso = request.getParameter("nombre");
        String codigoCurso = request.getParameter("codigo");

        if ("registrar".equalsIgnoreCase(accion)) {
            if (nombreCurso == null || nombreCurso.isBlank()
                    || codigoCurso == null || codigoCurso.isBlank()) {
                request.setAttribute("error", "El nombre y el código del curso son obligatorios.");
                request.getRequestDispatcher("/cursos.jsp").forward(request, response);
                return;
            }

            // TODO: Crear objeto Curso y llamar a registrarCurso(curso) cuando esté en el repo:
            // Curso nuevoCurso = new Curso(...);
            // boolean guardado = cursoDAO.registrarCurso(nuevoCurso);

            response.sendRedirect(request.getContextPath() + "/CursoServlet?mensaje=registrado");
        } else {
            response.sendRedirect(request.getContextPath() + "/CursoServlet");
        }
    }
}