/*
Autor: Gamaliel Silva Lopez 
Fecha creación: 16/03/2022
Fecha actualización: 16/03/2022
Descripción: Interfaz de servicio para usuario
*/

package Service;

import entity.Usuario;
import java.util.List;

public interface IUsuarioService {
 public void crearRegistro(Usuario usuario);
 public void actualizarRegistro(Usuario usuario);
 public void eliminarRegistro(int idUsuario);
 public List<Usuario> obtenerRegistros();
 public Usuario obtenerRegistro(int idUsuario);
}
