/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.src.models;

/**
 *
 * @author User
 */
public class Etiquetas {
    private int id_etiquetas;
    private String nombre_etiquetas;
    private String color_etiquetas;

    public Etiquetas() {
    }

    public Etiquetas(int id_etiquetas, String nombre_etiquetas, String color_etiquetas) {
        this.id_etiquetas = id_etiquetas;
        this.nombre_etiquetas = nombre_etiquetas;
        this.color_etiquetas = color_etiquetas;
    }

    public int getId_etiquetas() {
        return id_etiquetas;
    }

    public void setId_etiquetas(int id_etiquetas) {
        this.id_etiquetas = id_etiquetas;
    }

    public String getNombre_etiquetas() {
        return nombre_etiquetas;
    }

    public void setNombre_etiquetas(String nombre_etiquetas) {
        this.nombre_etiquetas = nombre_etiquetas;
    }

    public String getColor_etiquetas() {
        return color_etiquetas;
    }

    public void setColor_etiquetas(String color_etiquetas) {
        this.color_etiquetas = color_etiquetas;
    }
    
    
}
