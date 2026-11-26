package com.mycompany.edustreamlms.seguridad;

import com.edustream.edustream.Usuario;

public class Sesion {

  //Aca debemos cambiar el Usuario que vamos hacer el Log in en la siguiente linea , debo hablarlo con los compas
    private Usuario Usuario_que_logueamos;

    public void iniciarSesion(Usuario usuario) {

        Usuario_que_logueamos = usuario;

        System.out.println("Sesion iniciada correctamente.");
    }
//Aca tambien igual
    public Usuario getUsuario_que_logueamos() {
//Aca tambien
        return Usuario_que_logueamos;
    }

    public boolean sesionActiva() {
//Also
        return Usuario_que_logueamos != null;
    }

    public void cerrarSesion() {

        Usuario_que_logueamos = null;

        System.out.println("Sesion cerrada correctamente.");
    }
}
