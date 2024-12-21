package com.mycompany.src.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String USUARIO = "adminServer";
    private static final String CONTRASENA = "admin123";
    private static final String BASE_DATOS = "toDoSistemas";
    private static final String SERVIDOR = "DESKTOP-HMMHCJV\\SQLEXPRESS";
    private static final String PUERTO = "1433";

    private static final String CADENA_CONEXION = 
        "jdbc:sqlserver://" + SERVIDOR + ":" + PUERTO + ";"
        + "databaseName=" + BASE_DATOS + ";"
        + "encrypt=true;trustServerCertificate=true;";

    public Connection establecerConexion() {
        Connection conectar = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conectar = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENA);
            System.out.println("Se conectó exitosamente a la base de datos");
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC no encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general al conectar: " + e.getMessage());
        }
        return conectar;
    }
    
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.establecerConexion();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente");
        } else {
            System.out.println("No se pudo establecer la conexión");
        }
    }
}
