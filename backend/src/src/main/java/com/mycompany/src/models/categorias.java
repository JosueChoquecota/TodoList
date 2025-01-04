
package com.mycompany.src.models;


public class categorias {
    private int id_etiquetas;
    private String nombre_categorias;
    protected String descripcion_categoria;

    public categorias() {
    }

    public categorias(int id_etiquetas, String nombre_categorias, String descripcion_categoria) {
        this.id_etiquetas = id_etiquetas;
        this.nombre_categorias = nombre_categorias;
        this.descripcion_categoria = descripcion_categoria;
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

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    @Override
    public String toString() {
        return "\nCategorias----" 
                + "\nid_etiquetas=" + id_etiquetas 
                + "\nnombre_categorias=" + nombre_categorias 
                + "\ndescripcion_categoria=" + descripcion_categoria ;
    }
    
    
    
    
}
