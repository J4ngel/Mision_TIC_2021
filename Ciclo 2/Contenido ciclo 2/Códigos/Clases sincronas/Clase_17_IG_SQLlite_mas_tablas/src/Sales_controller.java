import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Conexion.*;

public class Sales_controller implements Initializable{

    @FXML
    private ChoiceBox<String> chb_producto;
    ObservableList<String> productos = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> chb_cliente;
    ObservableList<String> clientes = FXCollections.observableArrayList();

    @FXML
    private Button btn_registrar;

    @FXML
    private TextField txt_cantidad;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_apellido;

    @FXML
    private TextField txt_genero;

    @FXML
    private Button btn_add_cliente;

    Connect objconexion = new Connect();
    Connection conn = objconexion.conexion();

    void o_lista_prod(){
        String sql = "SELECT * FROM productos ORDER BY codigo";
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while(result.next()) {
                productos.add(result.getInt("codigo")+"-"+result.getString("nombre"));
            }
            chb_producto.setItems(productos);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    void o_lista_client(){
        String sql = "SELECT * FROM clientes ORDER BY id";
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while(result.next()) {
                clientes.add(result.getInt("id")+"-"+result.getString("nombre"));
            }
            chb_cliente.setItems(clientes);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public int existe_id(){
        String sql = "SELECT cedula FROM clientes WHERE cedula = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_id.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){return 1;}

        }catch(SQLException e){
            System.out.println("Error en validar cedula "+e.getMessage());
        }
        return 0;
    }

    @FXML
    void Add_cliente(ActionEvent event) {
        Integer cc = Integer.parseInt(txt_id.getText());
        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        String genero = txt_genero.getText();

        String sql = "INSERT INTO clientes(cedula, nombre, apellido, genero) VALUES(?,?,?,?)";
        try{
            if(existe_id() == 0){
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, cc);
                ps.setString(2, nombre);
                ps.setString(3, apellido);
                ps.setString(4, genero);
                ps.executeUpdate();

                System.out.println("El cliente fue creado con exito !!");
            }else{
                System.out.println("Cedula ya existe !!");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    String obtener_key(String cadena){
        String key[] = cadena.split("-"); //["1","Silla"] o ["1","Jaime"]
        return key[0];
    }

    @FXML
    void Registrar_venta(ActionEvent event) {
        Integer producto = Integer.parseInt(obtener_key(chb_producto.getValue())); 
        Integer cliente = Integer.parseInt(obtener_key(chb_cliente.getValue()));
        Integer cant = Integer.parseInt(txt_cantidad.getText());
        String sql = "INSERT INTO ventas(cliente, producto, cantidad) VALUES (?,?,?)";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cliente);
            ps.setInt(2,producto);
            ps.setInt(3,cant);
            ps.executeUpdate();
            System.out.println("Venta creada exitosamente !!");
        }catch(SQLException e){
            System.out.println("Error en crear venta "+e.getMessage());
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        productos.add("Sereccione Producto");
        o_lista_prod();
        clientes.add("Sereccione Cliente");
        o_lista_client();
        chb_producto.getSelectionModel().select(0);
        chb_cliente.getSelectionModel().select(0);  
    }

}