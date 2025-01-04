/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.src.dao;

import com.mycompany.src.models.Usuario;
import com.mycompany.src.models.categorias;
import com.mycompany.src.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CategoriaDAO {
    
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.establecerConexion();  
    //FUNCION QUE SOLO APLICA PARA ADMINISTRADORES 
    public void crearCategoria(categorias categoria) throws SQLException {
        try {
            
            String crearCategoria = "{call crearNuevaCategoria (?,?,?}";
            PreparedStatement stmt = conn.prepareStatement(crearCategoria);
            stmt.setInt(1, categoria.getId_etiquetas());
            stmt.setString(2, categoria.getNombre_categorias());
            stmt.setString(3, categoria.getDescripcion_categoria());
        
            stmt.executeUpdate();
            System.out.println("Categoria creada Exitosamente!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e ;
        }
    }
    
    public List <categorias> obtenerCategorias() throws SQLException {
        List <categorias> Categorias = new ArrayList<>();
        try {
            String sql = "select * from categorias";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                categorias categoria = new categorias();
                categoria.setId_etiquetas(rs.getInt("id_categoria"));
                categoria.setNombre_categorias(rs.getString("nombre_categoria"));
                categoria.setDescripcion_categoria(rs.getString("descripcion_categoria"));
                
                Categorias.add(categoria);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            throw e ;
        
        }
        return Categorias;
    }
    public void actualizarCategoria(categorias categoria) throws SQLException {
    try {
            StringBuilder consultaActualizar = new StringBuilder("UPDATE categorias SET ");
            List<Object> parametros = new ArrayList<>();

            if (categoria.getNombre_categorias() != null && !categoria.getNombre_categorias().isEmpty()) {
                consultaActualizar.append("nombre_categoria = ?, ");
                parametros.add(categoria.getNombre_categorias());
            }
            if (categoria.getDescripcion_categoria() != null && !categoria.getDescripcion_categoria().isEmpty()) {
                consultaActualizar.append("descripcion_categoria = ?, ");
                parametros.add(categoria.getDescripcion_categoria());
            }

            consultaActualizar.setLength(consultaActualizar.length() - 2);

            consultaActualizar.append(" WHERE id_categoria = ?");
            parametros.add(categoria.getId_etiquetas());

            PreparedStatement stmt = conn.prepareStatement(consultaActualizar.toString());
            for (int i = 0; i < parametros.size(); i++) {
                stmt.setObject(i + 1, parametros.get(i)); 
            }

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Categoría actualizada exitosamente!");
            } else {
                System.out.println("No se encontró la categoría especificada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }
    }

    public void eliminarCategoria(int id) throws SQLException {
     try {
         String eliminarCategoria = "DELETE FROM categorias where id_categoria =?";
         PreparedStatement stmt = conn.prepareCall(eliminarCategoria);
         
         stmt.setInt(1, id);
         stmt.executeUpdate();
         System.out.println("La Categoria ha sido Eliminada");
     }   catch (SQLException e) {
         e.printStackTrace();
     }
        
    } 
}
