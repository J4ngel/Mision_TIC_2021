import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Agenda implements Initializable {

    @FXML
    private TextField txt_nombres;

    @FXML
    private TextField txt_edad;

    @FXML
    private TextField txt_apellidos;

    @FXML
    private Button btn_agregar;

    @FXML
    private TableView<Persona> Tabla_personas;
    ObservableList<Persona> Contactos;

    @FXML
    private TableColumn<Persona,String> Columna_nombres;

    @FXML
    private TableColumn<Persona,String> Columna_apellidos;

    @FXML
    private TableColumn<Persona,Integer> Columna_edad;

    @FXML
    void Agregar(ActionEvent event) {
        String nom = txt_nombres.getText();
        String apellido = txt_apellidos.getText();
        int edad = Integer.parseInt(txt_edad.getText());
        Persona persona_a = new Persona(nom, apellido, edad);
        Contactos.addAll(persona_a);
        Tabla_personas.setItems(Contactos);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Contactos = FXCollections.observableArrayList(
            new Persona("Jaime","A",22),
            new Persona("Carmen","De avila", 25),
            new Persona("Wilhelm", "Geney", 23)
        );
        
        Columna_nombres.setCellValueFactory(
            new PropertyValueFactory<Persona, String>("nombres")
        );

        Columna_apellidos.setCellValueFactory(
            new PropertyValueFactory<Persona, String>("apellidos")
        );

        Columna_edad.setCellValueFactory(
            new PropertyValueFactory<Persona, Integer>("edad")
        );
        Tabla_personas.setItems(Contactos);
    }

}
