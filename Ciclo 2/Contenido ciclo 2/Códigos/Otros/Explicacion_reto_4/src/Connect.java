import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connect {
    public Connection conexion(){
        String url = "jdbc:sqlite:src/base_de_datos_prueba.db";
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
