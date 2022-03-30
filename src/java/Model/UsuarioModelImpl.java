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
            conexion.conecta();
            connection = conexion.getConnection();
            String sql = "Insert into usuarios (nombre_usuario, contraseña, nombre, sexo, edad) values(?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombre_Usuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getSexo());
            ps.setInt(5, usuario.getEdad());
            ps.executeUpdate();
            System.out.println("Correcto");
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.conecta();
            connection = conexion.getConnection();
            String sql = "Update usuarios set nombre_usuario=?, contraseña=?, nombre=?, sexo=?, edad=? where codigo=" + usuario.getCodigo() + ";";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombre_Usuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getSexo());
            ps.setInt(5, usuario.getEdad());
            ps.executeUpdate();
            System.out.println("Correcto");
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(int idUsuario) {
        try {
            conexion = new Conexion();
            conexion.conecta();
            connection = conexion.getConnection();
            String sql = "delete from usuarios where codigo=" + idUsuario + ";";
            Statement s = connection.createStatement();
            int rs = s.executeUpdate(sql);
            System.out.println("Correcto");
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Usuario> obtenerRegistros() {
        Usuario u;
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            conexion = new Conexion();
            conexion.conecta();
            connection = conexion.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM usuarios;");

            while (rs.next()) {
                u = new Usuario();
                u.setCodigo(rs.getString("codigo"));
                u.setNombre_Usuario(rs.getString("nombre_usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setNombre(rs.getString("nombre"));
                u.setSexo(rs.getString("sexo"));
                u.setEdad(rs.getInt("edad"));
                lista.add(u);
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Usuario obtenerRegistro(int idUsuario) {
        Usuario u = new Usuario();
        try {
            conexion = new Conexion();
            conexion.conecta();
            connection = conexion.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM usuarios where codigo=" + idUsuario + ";");
            while (rs.next()) {
                u.setCodigo(rs.getString("codigo"));
                u.setNombre_Usuario(rs.getString("nombre_usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setNombre(rs.getString("nombre"));
                u.setSexo(rs.getString("sexo"));
                u.setEdad(rs.getInt("edad"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }

    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setCodigo("2");
        u.setContraseña("87691520");
        u.setEdad(20);
        u.setNombre("Ivan");
        u.setNombre_Usuario("wos");
        u.setSexo("Masculino");
        UsuarioModelImpl m = new UsuarioModelImpl();
        m.crearRegistro(u);
        u = m.obtenerRegistro(1);
        System.out.println(u.getCodigo());

    }
}
