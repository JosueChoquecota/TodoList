
package com.mycompany.src.dao;

import com.mycompany.src.models.actividades;
import com.mycompany.src.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ActividadDAO {
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.establecerConexion();  
    
    public void crearActividad(actividades actividad) throws SQLException {
    try {
        String crearActividad = "{call crearNuevaActividad = (?,?,?,?,?)}";
        PreparedStatement stmt = conn.prepareStatement(crearActividad);
        stmt.setInt(1, actividad.getId_actividad());
        stmt.setInt(2, actividad.getId_tarea());
        stmt.setInt(3, actividad.getId_usuario());
        stmt.setString(4, actividad.getAccion());
        stmt.setDate(5, actividad.getFecha());
        stmt.executeUpdate();
        System.out.println("Actividad creada Exitosamente");
    
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
    }
    public List <actividades> obtenerActividades() throws SQLException {
        List<actividades> Actividades = new ArrayList<>();
        try {
            String sql = "SELECT * FROM actividades";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                actividades actividad = new actividades();
                actividad.setId_actividad(rs.getInt("id_actividad"));
                actividad.setId_tarea(rs.getInt("id_tarea"));
                actividad.setId_usuario(rs.getInt("id_usuario"));
                actividad.setAccion(rs.getString("accion"));
                actividad.setFecha(rs.getDate("fecha"));
                
                Actividades.add(actividad);
            } 
        }catch (SQLException e) {
                e.printStackTrace();
                    
        }
    
        return Actividades;
    }
    
    public void actualizarActividad(actividades actividad) throws SQLException {
        try {
           StringBuilder consultaActualizar = new StringBuilder("UPDATE actividades SET ");
           List<Object> parametros = new ArrayList<>();

           if (actividad.getId_tarea() != 0) {
               consultaActualizar.append("id_tarea = ?, ");
               parametros.add(actividad.getId_tarea());
           }
           if (actividad.getId_usuario() != 0) {
               consultaActualizar.append("id_usuario = ?, ");
               parametros.add(actividad.getId_usuario());
           }
           if (actividad.getAccion() != null && !actividad.getAccion().isEmpty()) {
               consultaActualizar.append("accion = ?, ");
               parametros.add(actividad.getAccion());
           }
           if (actividad.getFecha() != null) {
               consultaActualizar.append("fecha = ?, ");
               parametros.add(new java.sql.Date(actividad.getFecha().getTime())); // Formatear fecha
           }

           consultaActualizar.setLength(consultaActualizar.length() - 2);

           consultaActualizar.append(" WHERE id_actividad = ?");
           parametros.add(actividad.getId_actividad());

           PreparedStatement stmt = conn.prepareStatement(consultaActualizar.toString());

           for (int i = 0; i < parametros.size(); i++) {
               stmt.setObject(i + 1, parametros.get(i));
           }

           int filasActualizadas = stmt.executeUpdate();
           if (filasActualizadas > 0) {
               System.out.println("Actividad actualizada exitosamente!");
           } else {
               System.out.println("No se encontró la actividad especificada.");
           }

       } catch (SQLException e) {
           e.printStackTrace();
           throw e; 
       }

    
    }
    
    public void eliminarActividad(int id) throws SQLException {
        try {
            String eliminarActividad = "DELETE FROM actividades WHERE id_actividad = ?";
            PreparedStatement stmt = conn.prepareCall(eliminarActividad);
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("La Actividad fue eliminada Exitosamente");
        
        } catch (SQLException e) {
            e.printStackTrace();  
        }
    }

}
