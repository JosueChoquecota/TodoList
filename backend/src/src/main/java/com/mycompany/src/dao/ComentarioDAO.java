/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.src.dao;

import com.mycompany.src.models.comentarios;
import com.mycompany.src.utils.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO {
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.establecerConexion();  
    
    public void crearComentario(comentarios comentario) throws SQLException {
    
        try {
            String crearComentario = "{call crearNuevoComentario(?,?,?,?,?)}";
                PreparedStatement stmt = conn.prepareCall(crearComentario);
                stmt.setInt(1, comentario.getId_comentario());
                stmt.setInt(2, comentario.getId_tarea());
                stmt.setInt(3, comentario.getId_usuario());
                stmt.setString(4, comentario.getContenido());
                stmt.executeUpdate();
                System.out.println("Comentario creado Exitosamente");
        
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public List<comentarios> obtenerComentarios() throws SQLException {
        List<comentarios> Comentario = new ArrayList<>();
        try{
            String sql = "Select * from comentarios";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                comentarios comentario = new comentarios();
                comentario.setId_comentario(rs.getInt("id_comentario"));
                comentario.setId_tarea(rs.getInt("id_tarea"));
                comentario.setId_usuario(rs.getInt("id_usuario"));
                comentario.setContenido(rs.getString("contenido"));
                comentario.setFecha_creacion(rs.getDate("fecha_creacion"));
                comentario.setActualizado_en(rs.getDate("actualizado_en"));
                
                Comentario.add(comentario);
            }
        
        
        } catch (SQLException e) {
                    e.printStackTrace();
                    throw e; 
        }
    
        return Comentario;
    }   
    
    public void actualizarComentario(comentarios comentario) throws SQLException {
        try {
            // Construir la consulta dinámica
            StringBuilder consultaActualizar = new StringBuilder("UPDATE comentarios SET ");
            List<Object> parametros = new ArrayList<>();

            // Validar y agregar campos dinámicos
            if (comentario.getContenido() != null && !comentario.getContenido().isEmpty()) {
                consultaActualizar.append("contenido = ?, ");
                parametros.add(comentario.getContenido());
            }

            // Actualizar automáticamente el campo actualizado_en
            consultaActualizar.append("actualizado_en = GETDATE(), ");

            // Eliminar la última coma y espacio
            consultaActualizar.setLength(consultaActualizar.length() - 2);

            // Añadir condición WHERE
            consultaActualizar.append(" WHERE id_comentario = ?");
            parametros.add(comentario.getId_comentario());

            // Preparar la consulta SQL
            PreparedStatement stmt = conn.prepareStatement(consultaActualizar.toString());

            // Asignar parámetros dinámicamente
            for (int i = 0; i < parametros.size(); i++) {
                stmt.setObject(i + 1, parametros.get(i));
            }

            // Ejecutar actualización
            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Comentario actualizado exitosamente!");
            } else {
                System.out.println("No se encontró el comentario especificado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Relanzar excepción
        }
    
    }
    
    public void eliminarComenatario(int id) throws SQLException {
        try {
            String eliminarComentario = "DELETE FROM comentarios where id_comentario =?";
            PreparedStatement stmt = conn.prepareCall(eliminarComentario);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Ccomentario elimnado Exitosamente!");
        
        }catch (SQLException e) {
                e.printStackTrace();
       
         }
    
    
    }
}
