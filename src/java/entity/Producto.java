/*
Autor: Jesús Fernando Hernández Vite 
Fecha creación: 07/03/2022
Fecha actualización: 07/03/2022
Descripción: Clase producto, se declara el get y el set 
*/

package entity;

import java.util.ArrayList;
import java.util.List;


   public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;
    
    public Producto(){
        
    }
    public Producto(String codigo, String nombre, double precio, String descripcion){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public static void main(String[] args) {
        Producto p = new Producto("70805", "Tenis", 1500,"Tenis Nike");
        Producto p2 = new Producto("70806", "Gorra", 1500,"Gorra Puma");
        Producto p3 = new Producto("70807", "Jersey", 1500,"Jersey de futbol Nike");
        
        List<Producto> lista = new ArrayList<Producto>();
        
        lista.add(p);
        lista.add(p2);
        lista.add(p3);
        
        for (Producto i : lista){
            System.out.println(i.getCodigo());
            System.out.println(i.getNombre());
            System.out.println(i.getPrecio());
            System.out.println(i.getDescripcion());
        }
    }
}

