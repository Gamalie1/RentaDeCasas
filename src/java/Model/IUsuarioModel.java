/*
 Autor: Gamaliel Silva Lopez
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
    public void crearRegistro (Usuario usuario);
    public void actualizarRegistro(Usuario usuario);
    public void elminarRegistro(String idUsuario);
    public List<Usuario> obtenerREgistros();
    public Usuario obtenerRegistro(String codigo);
    //public Usuario obtenerRegistro(int idUsuario);
    
   
    
    
}
