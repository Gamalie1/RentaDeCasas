/*
 Autor: Gamaliel Silva Lopez
 Fecha de creacion: 7 de marzo de 2022
 Fecha de modificacion: 10 de marzo de 2022
 Descripcion: Clase conexion
 */
package db;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    static Connection conexion;
    static ResultSet rs = null;
    String url;
    String user;
    String password;

    public Conexion() {
        url= "jdbc:postgresql://localhost/casas";
        user= "postgres";
        password= "HOLA";
    }

    

    public Connection Conectar() {
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion con exito");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return con;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void Desconectar() {
        try {
            conexion.close();
            System.out.println("Conexion cerrada");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void insertarDatos() { //Metodo que ayuda a dar de alta los productos
        try {
            String codigo = "001";
            String nombre = "Casa grande";
            String descripcion = "Cuenta con 4 cuartos";
            float precio = (float) 100.0;
            String FechaCreacion = "08/03/2022";
            String FechaActualizacion = "09/03/2022";
            String FechaEliminacion = "08/03/2022";

            String sql = "INSERT INTO producto (codigo, nombre, descripcion, precio, FechaCreacion, FechaActualizacion, FechaEliminacion) values(?, ?, ?, ?, ?, ?,?);";

            PreparedStatement ps = conexion.prepareStatement(sql);
            //Se obtinen los datos de los campos
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.setFloat(4, precio);

            ps.setString(5, FechaCreacion);
            ps.setString(6, FechaActualizacion);
            ps.setString(7, FechaCreacion);
            ps.setString(5, FechaEliminacion);
            ps.executeUpdate();//Se insertan los datos en la base de datos
            JOptionPane.showMessageDialog(null, "datos insertados correctamente");
            conexion.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    



    public static void main(String[] args) {
        
        Conexion con = new Conexion();
        con.Conectar();
        con.insertarDatos();
      
        con.Desconectar();
    }



}
