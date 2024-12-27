/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.src.models;

/**
 *
 * @author User
 */
public class categorias {
    private int id_etiquetas;
    private String nombre_categorias;

    public categorias() {
    }

    public categorias(int id_etiquetas, String nombre_categorias) {
        this.id_etiquetas = id_etiquetas;
        this.nombre_categorias = nombre_categorias;
    }

    public int getId_etiquetas() {
        return id_etiquetas;
    }

    public void setId_etiquetas(int id_etiquetas) {
        this.id_etiquetas = id_etiquetas;
    }

    public String getNombre_categorias() {
        return nombre_categorias;
    }

    public void setNombre_categorias(String nombre_categorias) {
        this.nombre_categorias = nombre_categorias;
    }
    
    
}
