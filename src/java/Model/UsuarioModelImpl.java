/*
 Autor: Gamaliel Silva Lopez
 Fecha de creacion: 11 de marzo de 2022
 Fecha de modificacion: 15 de marzo de 2022
 Descripcion: Se crea una clase donde se implementan todos los metoso de IUsuarioModel
 */
package Model;

import db.Conexion;
import entity.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioModelImpl implements IUsuarioModel {

    private Conexion conexion;
    private Connection connection;

    @Override
    public void crearRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConexion();
            String sql = "insert into usuario(codigo, nombreusuario, contraseña) values (?,?,?);";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getCodigo());
                statement.setString(2, usuario.getNombreUsuario());
                statement.setString(3, usuario.getContraseña());
                statement.executeUpdate();
                System.out.println("Datos insertados");
            }
            conexion.Desconectar();
        } catch (Exception c) {
            System.out.println("Error: " + c);
        }
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConexion();
            String sql = "update usuario set codigo =?, nombreusuario=?, contraseña=? ";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getCodigo());
                statement.setString(2, usuario.getNombreUsuario());
                statement.setString(3, usuario.getContraseña());
           
                statement.executeUpdate();
                System.out.println("Datos actualizados");
            }
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    @Override
    public void elminarRegistro(String idUsuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConexion();
            String sql = "delete from usuario where codigo= '"+idUsuario+"';";
            Statement s = connection.createStatement();
            int rs = s.executeUpdate(sql);
            System.out.println("Datos elimanados");
            conexion.Desconectar();
        } catch (Exception c) {
            System.out.println("Error: " + c);
        }
    }

    @Override
    public List<Usuario> obtenerREgistros() {
        List<Usuario> listausuario = null;
        try {
            ResultSet resulSet;
            listausuario = new ArrayList<>();
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConexion();
            String sql = "select * from usuario";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                resulSet = statement.executeQuery();

                while (resulSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setCodigo(resulSet.getString(1));
                    usuario.setNombreUsuario(resulSet.getString(2));
                    usuario.setContraseña(resulSet.getString(3));
                    listausuario.add(usuario);
                }
            }
            conexion.Desconectar();
        } catch (Exception c) {
            System.out.println("Error: " + c);
        }
        return listausuario;
    }

    @Override
    public Usuario obtenerRegistro(String  codigo) {
        Usuario usuario = null;
        try {
            ResultSet resulSet;
            usuario = new Usuario();
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConexion();
            String sql = "select * from usuario where codigo=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                 statement.setString(1, codigo);
                resulSet = statement.executeQuery();

                while (resulSet.next()) {

                    usuario.setCodigo(resulSet.getString(1));
                    usuario.setNombreUsuario(resulSet.getString(2));
                    usuario.setContraseña(resulSet.getString(3));

                }
            }
            conexion.Desconectar();
        } catch (Exception c) {
            System.out.println("Error: " + c);
        }
        return usuario;

    }

    public static void main(String[] args) {
        Usuario u1 = new Usuario();
        u1.setCodigo("02");
        u1.setNombreUsuario("GAMAS");
        u1.setContraseña("123");
        UsuarioModelImpl p1 = new UsuarioModelImpl();
        p1.crearRegistro(u1);
      // p1.actualizarRegistro(u1);
       // p1.elminarRegistro("02");
       List<Usuario> listausuario=p1.obtenerREgistros();
        for (Usuario usr:listausuario) {
            System.out.println(usr.getCodigo());
            System.out.println(usr.getNombreUsuario());
            System.out.println(usr.getContraseña());
        }
        
       // u1=p1.obtenerRegistro("02");
       // System.out.println(u1.getNombreUsuario());
       
        

    }
}
