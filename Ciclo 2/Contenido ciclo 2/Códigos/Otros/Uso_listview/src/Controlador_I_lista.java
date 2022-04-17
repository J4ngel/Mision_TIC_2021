import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controlador_I_lista implements Initializable{

    @FXML
    private ListView<Persona> Lista_usuarios;
    ObservableList<Persona> Contactos;

    @FXML
    private TextArea txt_salida;

    @FXML
    private RadioButton rdb_manzana;

    @FXML
    private ToggleGroup Frutas;

    @FXML
    private RadioButton rdb_freijoa;

    @FXML
    private RadioButton rdb_pera;

    @FXML
    private Label txt_RBSelect;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_rol;

    @FXML
    private TextField txt_edad;

    @FXML
    private Button btn_consultar;

    @FXML
    private Button btn_agregar;

    @FXML
    void Agregar_nuevo(ActionEvent event) {
        String nom, rol, edad;
        nom = txt_nombre.getText();
        rol = txt_rol.getText();
        edad = txt_edad.getText();
        Persona new_user = new Persona(nom,rol,edad);
        Contactos.addAll(new_user);
        Lista_usuarios.setItems(Contactos);
    }

    @FXML
    void Consultar(ActionEvent event) {
        Persona Usuario = Lista_usuarios.getSelectionModel().getSelectedItem();
        txt_salida.setText("Nombre: "+Usuario.getNombre()+"\nRol: "+Usuario.getRol()+"\nEdad: "+Usuario.getEdad());
    }

    @FXML
    void Freijoa(ActionEvent event) {
        txt_RBSelect.setText("Freijoa");
    }

    @FXML
    void Manzana(ActionEvent event) {
        txt_RBSelect.setText("Manzana");
    }

    @FXML
    void Pera(ActionEvent event) {
        txt_RBSelect.setText("Pera");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Contactos = FXCollections.observableArrayList(
            new Persona("Jaime","Estidiante","23"),
            new Persona("Daniela","Soporte tecnico","23"),
            new Persona("Cristian","Ingeniero","25"));
        Lista_usuarios.setItems(Contactos);
    }

    /* public Persona busqueda(String nombre){
        
    } */
}
