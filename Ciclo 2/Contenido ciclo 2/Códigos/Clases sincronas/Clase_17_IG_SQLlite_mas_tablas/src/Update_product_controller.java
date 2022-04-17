
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Update_product_controller {

    @FXML
    private TextField txt_actualizar_codigo;

    @FXML
    private TextField txt_actualizar_nombre;

    @FXML
    private TextField txt_actualizar_p_compra;

    @FXML
    private TextField txt_actualizar_p_venta;

    @FXML
    private TextField txt_actualizar_c_bodega;

    @FXML
    private TextField txt_actualizar_c_min;

    @FXML
    private TextField txt_actualizar_c_max;

    @FXML
    private Button btn_consultar;

    @FXML
    private Button btn_actualizar;

    @FXML
    private Button btn_eliminar;

    @FXML
    void Actualizar(ActionEvent event) {
        Integer Cod = Integer.parseInt(txt_actualizar_codigo.getText());
        String nomb = txt_actualizar_nombre.getText();
        Integer P_comp = Integer.parseInt(txt_actualizar_p_compra.getText());
        Integer P_vent = Integer.parseInt(txt_actualizar_p_venta.getText());
        Integer C_bod = Integer.parseInt(txt_actualizar_c_bodega.getText());
        Integer C_min = Integer.parseInt(txt_actualizar_c_min.getText());
        Integer C_max = Integer.parseInt(txt_actualizar_c_max.getText());
        
        Connect objconexion = new Connect();
        String sql = "UPDATE Productos SET nombre = ?, precio_compra = ?, precio_venta = ?, cant_bodega = ?, cant_min_requerida = ?, cant_max_permitida = ? WHERE codigo = ?";
        
        try{
            Connection conn = objconexion.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nomb);
            ps.setInt(2, P_comp);
            ps.setInt(3, P_vent);
            ps.setInt(4, C_bod);
            ps.setInt(5, C_min);
            ps.setInt(6, C_max);
            ps.setInt(7, Cod);
            ps.executeUpdate();
            System.out.println("Actualización exitosa");
            limpiar();
            editar_cajas_false();
            conn.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void Consultar(ActionEvent event) {
        Connect objconexion = new Connect();
        String sql = "SELECT * FROM productos WHERE codigo = ?";

        try{
            Connection conn = objconexion.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txt_actualizar_codigo.getText()));
            
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                txt_actualizar_nombre.setText(result.getString("nombre"));
                txt_actualizar_p_compra.setText(String.valueOf(result.getInt("precio_compra")));
                txt_actualizar_p_venta.setText(String.valueOf(result.getInt("precio_venta")));
                txt_actualizar_c_bodega.setText(String.valueOf(result.getInt("cant_bodega")));
                txt_actualizar_c_min.setText(String.valueOf(result.getInt("cant_min_requerida")));
                txt_actualizar_c_max.setText(String.valueOf(result.getInt("cant_max_permitida")));
            }
            if(result.isClosed()) {System.out.println("VACIO");}
            editar_cajas();
            conn.close();

        }catch(SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    @FXML
    void Eliminar(ActionEvent event) {
        Integer Cod = Integer.parseInt(txt_actualizar_codigo.getText());
        
        Connect objconexion = new Connect();
        String sql = "DELETE FROM productos WHERE codigo = ?";

        try{
            Connection conn = objconexion.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Cod);
            ps.executeUpdate();
            System.out.println("Registro eliminado !!");
            limpiar();
            editar_cajas_false();
            conn.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    void limpiar(){
        txt_actualizar_codigo.setText("");
        txt_actualizar_nombre.setText("");
        txt_actualizar_p_compra.setText("");
        txt_actualizar_p_venta.setText("");
        txt_actualizar_c_bodega.setText("");
        txt_actualizar_c_min.setText("");
        txt_actualizar_c_max.setText("");
    }

    void editar_cajas(){
        txt_actualizar_nombre.setEditable(true);
        txt_actualizar_p_compra.setEditable(true);
        txt_actualizar_p_venta.setEditable(true);
        txt_actualizar_c_bodega.setEditable(true);
        txt_actualizar_c_min.setEditable(true);
        txt_actualizar_c_max.setEditable(true);
    }

    void editar_cajas_false(){
        txt_actualizar_nombre.setEditable(false);
        txt_actualizar_p_compra.setEditable(false);
        txt_actualizar_p_venta.setEditable(false);
        txt_actualizar_c_bodega.setEditable(false);
        txt_actualizar_c_min.setEditable(false);
        txt_actualizar_c_max.setEditable(false);
    }
}

