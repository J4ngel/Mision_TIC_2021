
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import Conexion.Connect;

public class Inicio_controller {

    @FXML
    private Button btn_volver;

    @FXML
    private TextField txt_Codgo;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_P_compra;

    @FXML
    private TextField txt_P_venta;

    @FXML
    private TextField txt_C_bodega;

    @FXML
    private TextField txt_C_requerida;

    @FXML
    private TextField C_maxima;

    @FXML
    private Button btn_crear;

    @FXML
    private Button btn_ver_productos;

    @FXML
    private TextArea txt_product_list;

    @FXML
    private Button btn_registrar_ventas;

    @FXML
    private Button btn_consultar;

    void limpiar(){
        txt_Codgo.setText("");
        txt_nombre.setText("");
        txt_P_compra.setText("");
        txt_P_venta.setText("");
        txt_C_bodega.setText("");
        txt_C_requerida.setText("");
        C_maxima.setText("");
    }

    @FXML
    void CREAR_PRODUCTO(ActionEvent event) {
        Connect objconexion = new Connect();

        Integer cod = Integer.parseInt(txt_Codgo.getText());
        String nomb = txt_nombre.getText();
        Integer P_comp = Integer.parseInt(txt_P_compra.getText());
        Integer P_vent = Integer.parseInt(txt_P_venta.getText());
        Integer C_bod = Integer.parseInt(txt_C_bodega.getText());
        Integer C_min = Integer.parseInt(txt_C_requerida.getText());
        Integer C_max = Integer.parseInt(C_maxima.getText());

        String sql = "INSERT INTO Productos(codigo,nombre,precio_compra,precio_venta, cant_bodega, cant_min_requerida, cant_max_permitida) VALUES(?,?,?,?,?,?,?);";
        try{
            //Creacion de un obj de la clase Connect.java
            Connection conn = objconexion.conexion();
            //Con sentencias preparadas (mas seguro)
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.setString(2, nomb);
            ps.setInt(3, P_comp);
            ps.setInt(4, P_vent);
            ps.setInt(5, C_bod);
            ps.setInt(6, C_min);
            ps.setInt(7, C_max);
            ps.executeUpdate();
            //A pedal
            /* Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Productos(codigo,nombre,precio_compra,precio_venta, cant_bodega, cant_min_requerida, cant_max_permitida) VALUES("+cod +","+"'"+nomb+"'"+","+P_comp+","+P_vent+","+C_bod+","+C_min+","+C_max+");");
             */
            System.out.println("Producto creado");
            limpiar();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void Cerrar_Sesion(ActionEvent event) throws IOException{
        Stage frame2 = (Stage) btn_volver.getScene().getWindow();
        frame2.close();

        FXMLLoader file1 = new FXMLLoader(getClass().getResource("/Vistas/Login.fxml"));
        Parent root1 = file1.load();
        Scene frame1 = new Scene(root1);
        Stage secondStage = new Stage();
        secondStage.setTitle("Bienvenido");
        secondStage.setScene(frame1);
        secondStage.show();
    }

    @FXML
    void VER_PRODUCTOS(ActionEvent event) {
        Connect objConexion = new Connect();

        //queri/consulta etc
        String query = "SELECT * FROM Productos"; //Me devuelve todos los datos de base de datos
        //String query = "SELECT nombre FROM Productos"; //Me va a devolver todos los nombres de los productos
        try{
            Connection conn = objConexion.conexion();
            Statement stmt = conn.createStatement();
            
            //Clase ResultSet es donde se guarda el resutado de la consulta de la bse de datos

            ResultSet result = stmt.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            int n_columnas = rsmd.getColumnCount();
            String productos = "";
            while(result.next()){
                //El for i comienza en 1 porque 0 es el encabezado o titulos de la tabla
                for (int i = 1; i <= n_columnas; i++) {
                    String valor_columna = result.getString(i);
                    productos += rsmd.getColumnName(i)+": "+valor_columna+"\n";
                }
                productos += "\n";
            }
            txt_product_list.setText(productos);
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void Consultar(ActionEvent event) throws IOException {
        FXMLLoader file3 = new FXMLLoader(getClass().getResource("/Vistas/update.fxml"));
        Parent root3 = file3.load();
        Scene frame3 = new Scene(root3);
        Stage thrStage = new Stage();
        thrStage.setTitle("Consultar / Editar");
        thrStage.setScene(frame3);
        thrStage.show();
    }

    @FXML
    void Registrar_ventas(ActionEvent event) throws IOException {
        FXMLLoader file4 = new FXMLLoader(getClass().getResource("/Vistas/sales.fxml"));
        Parent root4 = file4.load();
        Scene frame4 = new Scene(root4);
        Stage forStage = new Stage();
        forStage.setTitle("Consultar / Editar");
        forStage.setScene(frame4);
        forStage.show();
    }
}