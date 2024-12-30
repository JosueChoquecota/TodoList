package com.mycompany.src.models;

import java.sql.Date;

public class Tarea {
    protected int id_tarea;
    private String nombre_tarea;
    protected String descripcion_tarea;
    protected boolean estado_tarea;
    protected Date fecha_vencimiento;
    private int id_usuario;

    public Tarea() {
    }

    public Tarea(int id_tarea, String nombre_tarea, String descripcion_tarea, boolean estado_tarea, Date fecha_vencimiento, int id_usuario) {
        this.id_tarea = id_tarea;
        this.nombre_tarea = nombre_tarea;
        this.descripcion_tarea = descripcion_tarea;
        this.estado_tarea = estado_tarea;
        this.fecha_vencimiento = fecha_vencimiento;
        this.id_usuario = id_usuario;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public String getDescripcion_tarea() {
        return descripcion_tarea;
    }

    public void setDescripcion_tarea(String descripcion_tarea) {
        this.descripcion_tarea = descripcion_tarea;
    }

    public boolean isEstado_tarea() {
        return estado_tarea;
    }

    public void setEstado_tarea(boolean estado_tarea) {
        this.estado_tarea = estado_tarea;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}