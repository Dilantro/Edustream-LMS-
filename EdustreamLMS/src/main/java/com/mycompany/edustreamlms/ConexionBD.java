package com.mycompany.edustreamlms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
  public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_grupo4";
        String usuario = "root";
        String contrasena = "CONTRASENA";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                url, usuario, contrasena
            );
            System.out.println("Conexion exitosa a la base de datos.");
            conexion.close();

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el Driver JDBC.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
    }
}

