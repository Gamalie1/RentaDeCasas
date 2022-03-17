/*
 Autor: Gamaliel Silva Lopez
 Fecha de creacion: 11 de marzo de 2022
 Fecha de modificacion: 16 de marzo de 2022
 Descripcion: Se crea una clase donde se hace instancia de IUsuarioModel y se toma en cuenta la parte del modelo.
 */
package Service;

import Model.UsuarioModelImpl;
import entity.Usuario;
import java.util.List;

/**
 *
 * @author labso08
 */
public class UsuarioServiceImpl implements IUsuarioService{
     //Instancioa al modelo
    UsuarioModelImpl modelo=new  UsuarioModelImpl();

    @Override
    public void crearRegistro(Usuario usuario) {
        modelo.crearRegistro(usuario);
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        modelo.actualizarRegistro(usuario);
    }
        
    @Override
    public void elminarRegistro(String idUsuario) {
       modelo.elminarRegistro(idUsuario);
    }

    @Override
    public List<Usuario> obtenerREgistros() {
        
        return modelo.obtenerREgistros();
    }

    @Override
    public Usuario obtenerRegistro(String codigo) {
         return (Usuario) modelo.obtenerREgistros();
    }
    
}
