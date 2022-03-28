/*
 Autor: Gamaliel Silva Lopez
 Fecha de creacion: 7 de marzo de 2022
 Fecha de modificacion: 10 de marzo de 2022
 Descripcion: Clase conexion 
 */
package db;

import java.sql.*;

public class Conexion {

    private Connection connection = null;
    private final String url;
    private final String user;
    private final String pwd;
  

    public Conexion() {
        this.url = "jdbc:postgresql://localhost/casas";
        this.user = "postgres";
        this.pwd = "medinagris";
    }

    public Connection conecta() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conexion exitosa");

        } catch (Exception ex) {
            System.out.println("Error al conectar:" + ex.getMessage());
        }
        return connection;
    }

    public void desconectar() {
        try {
            connection.close();
            System.out.println("Desconexion exitosa");
        } catch (Exception ex) {
            System.out.println("Error al desconectar:" + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        
        Conexion c= new Conexion();
        c.conecta();
        c.desconectar();
    }



}
