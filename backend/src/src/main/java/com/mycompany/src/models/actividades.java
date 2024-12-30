package com.mycompany.src.models;

import java.sql.Date;


public class actividades {
    protected int id_actividad;
    protected String descripcion_actividad;
    protected Date fecha;
    protected int tarea_id;

    public actividades() {
    }

    public actividades(int id_actividad, String descripcion_actividad, Date fecha, int tarea_id) {
        this.id_actividad = id_actividad;
        this.descripcion_actividad = descripcion_actividad;
        this.fecha = fecha;
        this.tarea_id = tarea_id;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getDescripcion_actividad() {
        return descripcion_actividad;
    }

    public void setDescripcion_actividad(String descripcion_actividad) {
        this.descripcion_actividad = descripcion_actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(int tarea_id) {
        this.tarea_id = tarea_id;
    }
    
    
    
}
