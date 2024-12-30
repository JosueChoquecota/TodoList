package com.mycompany.src.DAO;

import com.mycompany.src.models.Usuario;
import com.mycompany.src.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class    UsuarioDAO {
       
    
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.establecerConexion();   
    //CON ESTO CREO UN NUEVO USUARIO GAAAAAA
    public void crearUsuario(Usuario usuario) throws SQLException {
        
        try {
            //AQUI PREPARO LA CONSULTA A MI PROCEDURE
            String crearUsuarios =  "{call CrearUsuario(?,?,?,?,?,?,?,?)}";
            //AQUI INSERTO MIS DATOS
            PreparedStatement stmt = conn.prepareStatement(crearUsuarios);
            stmt.setInt(1, usuario.getId_usuario());
            stmt.setString(2,usuario.getNombre_usuario());
            stmt.setString(3, usuario.getEmail_usuario());
            stmt.setString(4, usuario.getPassword_usuario());
            stmt.setInt(5, usuario.getRol_id());
            stmt.setInt(6, usuario.getActivo());
            stmt.setString(7, usuario.getApellido_usuario());
            stmt.setString(8, usuario.getTelefono());
            
            stmt.executeUpdate();
            System.out.println("Usuario creado exitosamente!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } 
    }
    //MOSTRAR TODOS LOS DATOS DE MI USUARIO
    public List<Usuario> obtenerUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            String sql = "select id_usuario, nombre_usuario, email, contrasena, id_rol,activo,apellido_usuario, telefono from usuarios";
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql); 

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setEmail_usuario(rs.getString("email"));
                usuario.setPassword_usuario(rs.getString("contrasena"));
                usuario.setRol_id(rs.getInt("id_rol"));
                usuario.setActivo(rs.getInt("activo"));
                usuario.setApellido_usuario(rs.getString("apellido_usuario"));
                usuario.setTelefono(rs.getString("telefono"));
                
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } 
        return usuarios;
    }

    
    
    
}
