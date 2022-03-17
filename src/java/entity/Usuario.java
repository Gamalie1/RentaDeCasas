/*
 Autor: Gamaliel Silva Lopez
 Fecha de creacion: 7 de marzo de 2022
 Fecha de modificacion: 8 de marzo de 2022
 Descripcion: CLase usuario incluye get y set de usuario
 */
package entity;


import java.util.ArrayList;
import java.util.List;


public class Usuario extends Persona{
    private String codigo;
    private String nombreUsuario;
    private String contraseña;
    
    public Usuario(String codigo, String nombreUsuario, String contraseña) {
        this.codigo = codigo;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    public static void main(String[] args) {
        Usuario user1 = new Usuario("01", "Panchito", "123");
        Usuario user2 = new Usuario("02", "Pancho","321");
        Usuario user3 = new Usuario("03", "Pamela","234");
       List<Usuario> lista=new ArrayList<Usuario>();
       
//        
        lista.add(user1);
        lista.add(user2);
        lista.add(user3);
        
        for(Usuario i: lista){
            System.out.println(i.getCodigo());
            System.out.println(i.getNombre());
            System.out.println(i.getContraseña());
            
            System.out.println("\n");
        }
       
    }

    
    
    
    
}
