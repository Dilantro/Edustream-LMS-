package com.mycompany.edustreamlms.seguridad;

import com.edustream.edustream.Profesor;
import com.edustream.edustream.Estudiante;

public class Seguridad {

    public boolean verificarSesion(Sesion sesion) {

        if (sesion == null || !sesion.sesionActiva()) {

            System.out.println("Debe iniciar sesion.");

            return false;
        }

        return true;
    }

    public boolean permitirProfesor(Sesion sesion) {

        if (!verificarSesion(sesion)) {

            return false;
        }

        if (sesion.getUsuario_que_logueamos() instanceof Profesor) {

            return true;
        }

        System.out.println("Acceso denegado.");

        return false;
    }

    public boolean permitirEstudiante(Sesion sesion) {

        if (!verificarSesion(sesion)) {

            return false;
        }

        if (sesion.getUsuario_que_logueamos() instanceof Estudiante) {

            return true;
        }

        System.out.println("Acceso denegado.");

        return false;
    }
}
