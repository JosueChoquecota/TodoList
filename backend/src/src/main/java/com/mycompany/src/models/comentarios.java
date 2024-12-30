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
public class comentarios {
    protected int id_comentario;
    protected int tarea_id;
    protected String contenido;
    protected Date fecha_creacion;

    public comentarios() {
    }

    public comentarios(int id_comentario, int tarea_id, String contenido, Date fecha_creacion) {
        this.id_comentario = id_comentario;
        this.tarea_id = tarea_id;
        this.contenido = contenido;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public int getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(int tarea_id) {
        this.tarea_id = tarea_id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    
    
    
}
