
package com.mycompany.src.models;
public class tarea_etiquetas {
    private int tarea_id;
    private int etiqueta_id;
    
    public tarea_etiquetas() {
    }
    public tarea_etiquetas(int tarea_id, int etiqueta_id) {
        this.tarea_id = tarea_id;
        this.etiqueta_id = etiqueta_id;
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
    
}
