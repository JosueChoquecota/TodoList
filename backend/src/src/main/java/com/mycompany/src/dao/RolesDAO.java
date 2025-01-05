/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.src.dao;


import com.mycompany.src.models.roles;

import com.mycompany.src.utils.DatabaseConnection;
import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO {
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.establecerConexion();  
    
    public void crearRol(roles rol) throws SQLException {
        try {
            String crearRol = "{call crearNuevoRol (?,?,?)}";
                PreparedStatement stmt = conn.prepareCall(crearRol);
                stmt.setInt(1, rol.getRol_id());
                stmt.setString(2, rol.getNombre_rol());
                stmt.setString(3, rol.getDescripcion_rol());
                stmt.executeUpdate();
                System.out.println("Rol creado Exitosamente!");
        
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    
    }
    public List <roles> obtenerRoles() throws SQLException {
        List<roles> Roles = new ArrayList<>();
        try {
            String sql = "select * from roles";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                    roles rol = new roles();

                    rol.setRol_id(rs.getInt("id_rol"));
                    rol.setNombre_rol(rs.getString("nombre_rol"));
                    rol.setDescripcion_rol(rs.getString("descripcion_rol"));
                    Roles.add(rol);
                }       
            }catch (SQLException e) {
                        e.printStackTrace();
                        throw e; 
            }
    
        return Roles;
    }
    public void actualizarRol(roles rol) throws SQLException {
    try {
        StringBuilder consultaActualizar = new StringBuilder("UPDATE roles SET ");
        List<Object> parametros = new ArrayList<>();

        if (rol.getNombre_rol() != null && !rol.getNombre_rol().isEmpty()) {
            consultaActualizar.append("nombre_rol = ?, ");
            parametros.add(rol.getNombre_rol());
        }
        if (rol.getDescripcion_rol() != null && !rol.getDescripcion_rol().isEmpty()) {
            consultaActualizar.append("descripcion_rol = ?, ");
            parametros.add(rol.getDescripcion_rol());
        }

        consultaActualizar.setLength(consultaActualizar.length() - 2);

        consultaActualizar.append(" WHERE id_rol = ?");
        parametros.add(rol.getRol_id());

        PreparedStatement stmt = conn.prepareStatement(consultaActualizar.toString());

        for (int i = 0; i < parametros.size(); i++) {
            stmt.setObject(i + 1, parametros.get(i));
        }
        int filasActualizadas = stmt.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Rol actualizado exitosamente!");
        } else {
            System.out.println("No se encontró el rol especificado.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        throw e; 
    }
}
    
    
    
    public void eliminarRol(int id ) throws SQLException {
        try {
            String eliminarRol = "DELETE FROM roles where id_rol =?";
            PreparedStatement stmt = conn.prepareCall(eliminarRol);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Ccomentario elimnado Exitosamente!");
        
        
        }catch (SQLException e) {
                e.printStackTrace();
       
         }
    
    
    }
    
    
    
    
}
