package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connect {
    public Connection conexion(){
        //Ruta
        String url= "jdbc:sqlite:C:/Users/Jaime Andres Angel M/Desktop/MisiónTIC_2021/Ciclo 2/Programación/Clases sincronas/Clase_17_IG_SQLlite_mas_tablas/src/Base_de_datos/Almacen.db";
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
