
package com.mycompany.src.models;
public class tarea_etiquetas {
    private int id_etiqueta_e;
    private int tarea_id;
    private int etiqueta_id;
    
    public tarea_etiquetas() {
    }

    public tarea_etiquetas(int id_etiqueta_e, int tarea_id, int etiqueta_id) {
        this.id_etiqueta_e = id_etiqueta_e;
        this.tarea_id = tarea_id;
        this.etiqueta_id = etiqueta_id;
    }

    public int getId_etiqueta_e() {
        return id_etiqueta_e;
    }

    public void setId_etiqueta_e(int id_etiqueta_e) {
        this.id_etiqueta_e = id_etiqueta_e;
    }

    public int getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(int tarea_id) {
        this.tarea_id = tarea_id;
    }

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
    }

    @Override
    public String toString() {
        return "\nTarea_etiquetas" 
                + "\nId_etiqueta_e= " + id_etiqueta_e 
                + "\nTarea_id= " + tarea_id 
                + "\nEtiqueta_id= " + etiqueta_id ;
    }
    
    
}
