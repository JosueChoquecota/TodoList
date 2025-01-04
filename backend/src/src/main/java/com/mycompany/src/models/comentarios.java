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
    protected int id_tarea;
    protected int id_usuario;
    protected String contenido;
    protected Date fecha_creacion;
    protected Date actualizado_en;

    public comentarios() {
    }

    public comentarios(int id_comentario, int id_tarea, int id_usuario, String contenido, Date fecha_creacion, Date actualizado_en) {
        this.id_comentario = id_comentario;
        this.id_tarea = id_tarea;
        this.id_usuario = id_usuario;
        this.contenido = contenido;
        this.fecha_creacion = fecha_creacion;
        this.actualizado_en = actualizado_en;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
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

    public Date getActualizado_en() {
        return actualizado_en;
    }

    public void setActualizado_en(Date actualizado_en) {
        this.actualizado_en = actualizado_en;
    }

    @Override
    public String toString() {
        return "\nComentarios---" 
                + "id_comentario=" + id_comentario 
                + "\nid_tarea=" + id_tarea 
                + "\nid_usuario=" + id_usuario 
                + "\ncontenido=" + contenido 
                + "\nfecha_creacion=" + fecha_creacion 
                + "\nactualizado_en=" + actualizado_en;
    }

    
    
    
    
}
