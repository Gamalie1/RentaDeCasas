/*
 Autor: Jesús Fernando Hernández Vite
 Fecha de creacion: 11 de marzo de 2022
 Fecha de modificacion: 11 de marzo de 2022
 Descripcion: Se crea una clase de tipo interface donde podremos declarar 
              nuestras diferentes metodos.
 */
package Model;
import java.util.*;
import entity.Usuario;
import java.sql.SQLException;


public interface IUsuarioModel {
    public void crearRegistro(Usuario usuario);
 public void actualizarRegistro(Usuario usuario);
 public void eliminarRegistro(int idUsuario);
 public List<Usuario> obtenerRegistros();
 public Usuario obtenerRegistro(int idUsuario);
    
   
    
    
}
