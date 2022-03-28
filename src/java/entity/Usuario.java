/*
Autor: Gamaliel Silva Lopez 
Fecha creación: 07/03/2022
Fecha actualización: 07/03/2022
Descripción: Clase que hereda de persona
*/

package entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
  private String codigo, nombre_Usuario, contraseña;

  public Usuario() {

    }  
  public Usuario(String codigo, String nombre_Usuario, String contraseña, String nombre, String sexo, int edad) {
        super(nombre, sexo, edad);
        this.codigo = codigo;
        this.nombre_Usuario = nombre_Usuario;
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public static void main(String[] args) {
        Usuario u = new Usuario("001","Paco", "ABC1", "11", "Hombre", 20 );
        Usuario u2 = new Usuario("002","Ana", "ABC2" , "22", "Hombre", 20);
        Usuario u3 = new Usuario("003","Lupe", "ABC3" , "33", "Hombre", 20);
        
        List<Usuario> lista = new ArrayList<Usuario>();
        
        lista.add(u);
        lista.add(u2);
        lista.add(u3);
        
        for (Usuario i : lista){
            System.out.println(i.getCodigo());
            System.out.println(i.getContraseña());
            System.out.println(i.getNombre_Usuario());
        }
    }
  
}
