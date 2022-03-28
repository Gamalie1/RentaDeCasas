/*
Autor: Gamaliel Silva Lopez 
Fecha creación: 07/03/2022
Fecha actualización: 07/03/2022
Descripción: Clase abstracta de persona
*/

package entity;

public abstract class Persona {
    private String nombre, sexo;
    private int edad;
    
    public Persona(){
        
    }
    public Persona(String nombre, String Sexo, int edad){
        this.nombre = nombre;
        this.sexo = Sexo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
