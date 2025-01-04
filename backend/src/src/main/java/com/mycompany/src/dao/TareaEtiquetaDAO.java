
package com.mycompany.src.dao;
import com.mycompany.src.models.tarea_etiquetas;
import com.mycompany.src.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TareaEtiquetaDAO {
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.establecerConexion();  
    
    public void crearTareaEtiqueta(tarea_etiquetas te) throws SQLException {
    try {
        String crearTE = "INSERT INTO tarea_etiquetas VALUES (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(crearTE);
        
        stmt.setInt(1, te.getId_etiqueta_e());
        stmt.setInt(2, te.getTarea_id());
        stmt.setInt(3, te.getId_etiqueta_e());
        stmt.executeUpdate();
        System.out.println("TE creado Exitosamente!");
    }catch (SQLException e) {
            e.printStackTrace();
        throw e ;
        }
    }
    
    public  List <tarea_etiquetas> obtenerTE() throws SQLException {
        List <tarea_etiquetas> te = new ArrayList<>();
        try {
            String sql = "select * from tarea_etiquetas";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tarea_etiquetas tet = new tarea_etiquetas();
                tet.setId_etiqueta_e(rs.getInt("id_tarea_e"));
                tet.setTarea_id(rs.getInt("id_tarea"));
                tet.setEtiqueta_id(rs.getInt("etiqueta_id"));
                te.add(tet);
                
            }
        
        }catch (SQLException e) {
                    e.printStackTrace();
                    throw e; 
            }
    return te;
    
    }
    
    public void actualizarTareaEtiqueta(tarea_etiquetas te) throws SQLException {
    try {
            StringBuilder consultaActualizar = new StringBuilder("UPDATE tarea_etiquetas SET ");
            List<Object> parametros = new ArrayList<>();

            if (te.getTarea_id() != 0) { 
                consultaActualizar.append("id_tarea = ?, ");
                parametros.add(te.getTarea_id());
            }
            if (te.getEtiqueta_id() != 0) { 
                consultaActualizar.append("etiqueta_id = ?, ");
                parametros.add(te.getEtiqueta_id());
            }

            consultaActualizar.setLength(consultaActualizar.length() - 2);

            consultaActualizar.append(" WHERE id_tarea = ? AND id_etiqueta = ?");
            parametros.add(te.getTarea_id()); // ID de tarea para identificar el registro
            parametros.add(te.getEtiqueta_id()); // ID de etiqueta para identificar el registro

            PreparedStatement stmt = conn.prepareStatement(consultaActualizar.toString());

            for (int i = 0; i < parametros.size(); i++) {
                stmt.setObject(i + 1, parametros.get(i));
            }

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Tarea-Etiqueta actualizada exitosamente!");
            } else {
                System.out.println("No se encontró la relación tarea-etiqueta especificada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }
    }

    
    
    public void eliminarTe(int id) throws SQLException {
        try {
            String eliminarConsulta = "DELETE FROM tarea_etiquetas WHERE id_tarea = ?";
                PreparedStatement stmt = conn.prepareCall(eliminarConsulta);
            
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("tarea_etiquetas eliminando  exitosamente");
            
            }catch (SQLException e) {
                e.printStackTrace();
       
         }
        
        
        }
    
    
    }
    
  
    
