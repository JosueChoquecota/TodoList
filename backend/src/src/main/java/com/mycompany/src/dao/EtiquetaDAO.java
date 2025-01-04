/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.src.dao;

import com.mycompany.src.models.Etiquetas;
import com.mycompany.src.utils.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtiquetaDAO {
    
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.establecerConexion();  
    
    public void crearEtiqueta(Etiquetas etiqueta) throws SQLException {
        try {
            String crearEtiqueta = "INSERT INTO etiquetas VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(crearEtiqueta);
            stmt.setInt(1, etiqueta.getId_etiquetas());
            stmt.setString(2, etiqueta.getNombre_etiquetas());
            
            stmt.executeUpdate();
            System.out.println("Etiqueta creada Existosa");
        } catch (SQLException e) {
            e.printStackTrace();
        throw e ;
        }
    }
    
    public List <Etiquetas>obtenerEtiquetas() throws SQLException {
        List <Etiquetas> etiquetas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM etiquetas";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            Etiquetas etiqueta = new Etiquetas();
            etiqueta.setId_etiquetas(rs.getInt("id_etiqueta"));
            etiqueta.setNombre_etiquetas(rs.getString("nombre_etiqueta"));
            etiquetas.add(etiqueta);
            }
        
        }catch (SQLException e) {
                    e.printStackTrace();
                    throw e; 
            }
        return etiquetas;

    } 
    public void actualizarEtiqueta(Etiquetas etiqueta) throws SQLException{
         try {
        StringBuilder consultaActualizar = new StringBuilder("UPDATE etiquetas SET ");
        List<Object> parametros = new ArrayList<>();

        if (etiqueta.getNombre_etiquetas() != null && !etiqueta.getNombre_etiquetas().isEmpty()) {
            consultaActualizar.append("nombre_etiqueta = ?, ");
            parametros.add(etiqueta.getNombre_etiquetas());
        }

        consultaActualizar.setLength(consultaActualizar.length() - 2);

        consultaActualizar.append(" WHERE id_etiqueta = ?");
        parametros.add(etiqueta.getId_etiquetas());

        PreparedStatement stmt = conn.prepareStatement(consultaActualizar.toString());

        for (int i = 0; i < parametros.size(); i++) {
            stmt.setObject(i + 1, parametros.get(i));
        }

        int filasActualizadas = stmt.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Etiqueta actualizada exitosamente!");
        } else {
            System.out.println("No se encontró la etiqueta especificada.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        throw e; 
    }
    
    }
    
    public void eliminarEtiqueta(int id ) throws SQLException {
    
        try {
            String eliminarEtiqueta = "DELETE FROM etiquetas WHERE id_etiqueta = ?";
            PreparedStatement stmt = conn.prepareCall(eliminarEtiqueta);
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Etiqueta elimnado exitosamente");
        }catch (SQLException e) {
                e.printStackTrace();
       
         }
    
    }
}
