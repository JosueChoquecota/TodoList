package com.mycompany.src.models;

import java.sql.Date;


public class actividades {
    protected int id_actividad;
    private int id_tarea;
    private int id_usuario;
    protected String accion;
    protected Date fecha;
    
    public actividades() {
    }

    public actividades(int id_actividad, int id_tarea, int id_usuario, String accion, Date fecha) {
        this.id_actividad = id_actividad;
        this.id_tarea = id_tarea;
        this.id_usuario = id_usuario;
        this.accion = accion;
        this.fecha = fecha;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\nActividades-----" 
                + "\nId_actividad=" + id_actividad 
                + "\nId_tarea=" + id_tarea 
                + "\nId_usuario=" + id_usuario 
                + "\nAccion=" + accion 
                + "\nFecha=" + fecha ;
    }
    
   
    
    
    
}
