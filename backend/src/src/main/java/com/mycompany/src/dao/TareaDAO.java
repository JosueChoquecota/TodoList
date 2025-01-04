package com.mycompany.src.dao;

import com.mycompany.src.models.Tarea;
import com.mycompany.src.utils.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.establecerConexion();  

    public void crearTarea(Tarea tarea) throws SQLException {
        try {
            String crearTarea = "{call crearNuevaTarea(?,?,?,?,?,?,?,?,?)}";
            
            PreparedStatement stmt = conn.prepareStatement(crearTarea);
            
            stmt.setInt(1, tarea.getId_tarea());
            stmt.setString(2, tarea.getNombre_tarea());
            stmt.setString(3, tarea.getDescripcion_tarea());
            stmt.setInt(4, tarea.getId_categoria());
            stmt.setInt(5, tarea.getCreado_por());
            stmt.setInt(6, tarea.getAsignado_por());
            stmt.setBoolean(7, tarea.isEstado_tarea());
            stmt.setString(8, tarea.getPrioridad());
            stmt.setDate(9, tarea.getFecha_vencimiento());
            
            stmt.executeUpdate();
            System.out.println("Tarea creada Existosamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        throw e ;
        }
    

        
    }
        public List <Tarea> obtenerTareas() throws SQLException {
        List<Tarea> tareas = new ArrayList<>();
        try {
            String sql = "select * from tareas";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setId_tarea(rs.getInt("id_tarea"));
                tarea.setNombre_tarea(rs.getString("titulo_tarea"));
                tarea.setDescripcion_tarea(rs.getString("descripcion_tarea"));
                tarea.setId_categoria(rs.getInt("id_categoria"));
                tarea.setCreado_por(rs.getInt("creado_por"));
                tarea.setAsignado_por(rs.getInt("asignado_a"));
                tarea.setEstado_tarea(rs.getBoolean("estado_tarea"));
                tarea.setPrioridad(rs.getString("prioridad"));
                tarea.setFecha_creacion(rs.getDate("fecha_creacion"));
                tarea.setFecha_vencimiento(rs.getDate("fecha_vencimiento"));
                tareas.add(tarea);
                }
            } catch (SQLException e) {
                    e.printStackTrace();
                    throw e; 
            }
            return tareas;
        }
        public void actualizarTarea(Tarea tarea) throws SQLException {
        try {

            StringBuilder consultaActualizar = new StringBuilder("UPDATE tareas SET ");
            List<Object> parametros = new ArrayList<>();


            if (tarea.getNombre_tarea() != null) {
                consultaActualizar.append("titulo_tarea = ?, ");
                parametros.add(tarea.getNombre_tarea());
            }
            if (tarea.getDescripcion_tarea() != null) {
                consultaActualizar.append("descripcion_tarea = ?, ");
                parametros.add(tarea.getDescripcion_tarea());
            }
            if (tarea.getId_categoria() != 0) {
                consultaActualizar.append("id_categoria = ?, ");
                parametros.add(tarea.getId_categoria());
            }
            if (tarea.getCreado_por() != 0) {
                consultaActualizar.append("creado_por = ?, ");
                parametros.add(tarea.getCreado_por());
            }
            if (tarea.getAsignado_por() != 0) {
                consultaActualizar.append("asignado_a = ?, ");
                parametros.add(tarea.getAsignado_por());
            }
            if (tarea.isEstado_tarea() != false) {
                consultaActualizar.append("estado_tarea = ?, ");
                parametros.add(tarea.isEstado_tarea());
            }
            if (tarea.getPrioridad() != null) {
                consultaActualizar.append("prioridad = ?, ");
                parametros.add(tarea.getPrioridad());
            }
            if (tarea.getFecha_vencimiento() != null) {
                consultaActualizar.append("fecha_vencimiento = ?, ");
                parametros.add(new java.sql.Timestamp(tarea.getFecha_vencimiento().getTime())); // Formatear fecha
            }

            consultaActualizar.setLength(consultaActualizar.length() - 2);

            consultaActualizar.append(" WHERE id_tarea = ?");
            parametros.add(tarea.getId_tarea());

            PreparedStatement stmt = conn.prepareStatement(consultaActualizar.toString());
            for (int i = 0; i < parametros.size(); i++) {
                stmt.setObject(i + 1, parametros.get(i)); 
            }

        stmt.executeUpdate();
        System.out.println("Tarea actualizada exitosamente!");

    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    } 
}

        
        
        public void eliminarTarea(int id ) throws SQLException {
            try {
                String eliminarConsulta = "DELETE FROM tarea WHERE id_tarea = ?";
                PreparedStatement stmt = conn.prepareCall(eliminarConsulta);
            
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Usuario eliminando  exitosamente");
            
            }catch (SQLException e) {
                e.printStackTrace();
       
         }
        
        
        }
        
    public static void main(String[] args) throws SQLException {
        // Crear conexión al DAO
        TareaDAO tareaDAO = new TareaDAO();
        System.out.println(tareaDAO.obtenerTareas());
        
    }




}