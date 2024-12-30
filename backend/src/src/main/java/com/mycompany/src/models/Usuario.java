package com.mycompany.src.models;

public class Usuario {
    protected int id_usuario;
    private String nombre_usuario;
    private String email_usuario;
    private String password_usuario;
    private int rol_id;
    private int activo;
    private String apellido_usuario;
    private String telefono;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String email_usuario, String password_usuario, int rol_id, int activo, String apellido_usuario, String telefono) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email_usuario = email_usuario;
        this.password_usuario = password_usuario;
        this.rol_id = rol_id;
        this.activo = activo;
        this.apellido_usuario = apellido_usuario;
        this.telefono = telefono;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario x"
                + "\nID_usuario: " + id_usuario
                + "\nNombre: " +nombre_usuario
                + "\nApellido: " + apellido_usuario
                + "\nEmail: " +  email_usuario
                + "\nContraseña: " + password_usuario
                + "\n Rol: " + rol_id
                + "\nActivo: " + activo
                + "\nTelefono: " + telefono
                ;
    }
    
    

}
