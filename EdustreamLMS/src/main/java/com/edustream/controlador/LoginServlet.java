package com.edustream.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet", "/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si entran por GET, enviamos a la vista de login (ajusta la ruta si usan otra)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String correoOusuario = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        // Validación básica de campos vacíos
        if (correoOusuario == null || correoOusuario.isBlank()
                || contrasena == null || contrasena.isBlank()) {
            request.setAttribute("error", "Debes ingresar tu correo/usuario y contraseña.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        // TODO: Conectar aquí con UsuarioDAO cuando esté listo, por ejemplo:
        // Usuario usuario = usuarioDAO.validarLogin(correoOusuario.trim(), contrasena);
        boolean credencialesValidas = true; // Placeholder temporal para probar el flujo

        if (credencialesValidas) {
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuarioCorreo", correoOusuario.trim());
            // sesion.setAttribute("usuarioLogueado", usuario);

            // Redirección tras iniciar sesión (ajusta según rol o vista principal)
            response.sendRedirect(request.getContextPath() + "/CursoServlet");
        } else {
            request.setAttribute("error", "Credenciales incorrectas.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}