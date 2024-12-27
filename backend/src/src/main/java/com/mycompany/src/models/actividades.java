/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.src.models;

import java.sql.Date;

/**
 *
 * @author User
 */
public class actividades {
    private int id_actividad;
    private String descripcion_actividad;
    private Date fecha;
    private int tarea_id;

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
