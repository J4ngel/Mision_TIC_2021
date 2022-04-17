package Clases;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connect {
    public Connection conexion(){
        String url = "jdbc:sqlite:src/Base de datos/Base_de_datos_estudiantes.db";
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
