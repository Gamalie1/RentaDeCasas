/*
 Autor: Gamaliel Silva Lopez
 Fecha de creacion: 7 de marzo de 2022
 Fecha de modificacion: 8 de marzo de 2022
 Descripcion: Clase prodcuto que contiene los get y set
 */
package entity;

import java.util.*;

public class Producto {

    private String codigo ;
    private String nombre;
    private Double precio;
    private String descripcion;

    public Producto() {

    }

    public Producto(String codigo, String nombre, Double precio, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static void main(String[] args) {
        Producto p1 = new Producto("001", "Casa grande", 1000.0, "Cuatro cuartos");
        Producto p2 = new Producto("002", "Casa grande", 1000.0, "Cuatro cuartos");
        Producto p3 = new Producto("003", "Casa grande", 1000.0, "Cuatro cuartos");
        List<Producto> lista = new ArrayList<Producto>();
        // ArrayList lista = new ArrayList();

//        lista.add(p1.getCodigo());
//        lista.add(p1.getNombre());
//        lista.add(p1.getPrecio());
//        lista.add(p1.getDescripcion());
//        
//        lista.add(p2.getCodigo());
//        lista.add(p2.getNombre());
//        lista.add(p2.getPrecio());
//        lista.add(p2.getDescripcion());
//        
//        lista.add(p3.getCodigo());
//        lista.add(p3.getNombre());
//        lista.add(p3.getPrecio());
//        lista.add(p3.getDescripcion());
//        
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        for (Producto i : lista) {
            System.out.println(i.getCodigo());
            System.out.println(i.getNombre());
            System.out.println(i.getPrecio());
            System.out.println(i.getDescripcion());
            System.out.println("\n");
        }

    }

}
