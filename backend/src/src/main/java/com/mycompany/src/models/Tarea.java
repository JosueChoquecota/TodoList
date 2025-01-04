package com.mycompany.src.models;

import java.sql.Date;

public class Tarea {
    protected int id_tarea;
    private String nombre_tarea;
    protected String descripcion_tarea;
    private int id_categoria;
    private int creado_por;
    private int asignado_por;
    protected boolean estado_tarea;
    protected String prioridad;
    protected Date fecha_creacion;
    protected Date fecha_vencimiento;
    

    public Tarea() {
    }

    public Tarea(int id_tarea, String nombre_tarea, String descripcion_tarea, int id_categoria, int creado_por, int asignado_por, boolean estado_tarea, String prioridad, Date fecha_vencimiento) {
        this.id_tarea = id_tarea;
        this.nombre_tarea = nombre_tarea;
        this.descripcion_tarea = descripcion_tarea;
        this.id_categoria = id_categoria;
        this.creado_por = creado_por;
        this.asignado_por = asignado_por;
        this.estado_tarea = estado_tarea;
        this.prioridad = prioridad;
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    public Tarea(int id_tarea, String nombre_tarea, String descripcion_tarea, int id_categoria, int creado_por, int asignado_por, boolean estado_tarea, String prioridad, Date fecha_creacion, Date fecha_vencimiento) {
        this.id_tarea = id_tarea;
        this.nombre_tarea = nombre_tarea;
        this.descripcion_tarea = descripcion_tarea;
        this.id_categoria = id_categoria;
        this.creado_por = creado_por;
        this.asignado_por = asignado_por;
        this.estado_tarea = estado_tarea;
        this.prioridad = prioridad;
        this.fecha_creacion = fecha_creacion;
        this.fecha_vencimiento = fecha_vencimiento;
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

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(int creado_por) {
        this.creado_por = creado_por;
    }

    public int getAsignado_por() {
        return asignado_por;
    }

    public void setAsignado_por(int asignado_por) {
        this.asignado_por = asignado_por;
    }

    public boolean isEstado_tarea() {
        return estado_tarea;
    }

    public void setEstado_tarea(boolean estado_tarea) {
        this.estado_tarea = estado_tarea;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    @Override
    public String toString() {
        return "\nTarea-----" 
                + "\nid_tarea = " + id_tarea 
                + "\nnombre_tarea = " + nombre_tarea 
                + "\ndescripcion_tarea = " + descripcion_tarea 
                + "\nid_categoria = " + id_categoria 
                + "\ncreado_por = " + creado_por 
                + "\nasignado_por = " + asignado_por 
                + "\nestado_tarea = " + estado_tarea 
                + "\nprioridad = " + prioridad 
                + "\nfecha_creacion = " + fecha_creacion 
                + "\nfecha_vencimiento = " + fecha_vencimiento;
    }

    
    
}