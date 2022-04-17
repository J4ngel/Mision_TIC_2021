import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controlador_interfaz implements Initializable{

    @FXML
    private TextField txt_nombre;

    @FXML
    private Button btn_saludar;

    @FXML
    private TextField txt_num1;

    @FXML
    private TextField txt_num2;

    @FXML
    private TextField txt_Salida;

    @FXML
    private Button btn_calcular;

    @FXML
    private ComboBox<String> cbx_Operaciones;
    ObservableList<String> op = FXCollections.observableArrayList("Suma", "Resta", "Multiplicación", "División");
    //ObservableList<String> op = FXCollections.observableArrayList(); //Lista vacia

    @FXML
    private RadioButton rdb_2dec;

    @FXML
    private RadioButton rdb_3dec;

    @FXML
    private RadioButton rdb_0dec;

    @FXML
    void Calcular(ActionEvent event) {
        String operacion = cbx_Operaciones.getSelectionModel().getSelectedItem().toString();
        String formato = "";
        int num1 = Integer.parseInt(txt_num1.getText());
        int num2 = Integer.parseInt(txt_num2.getText());
        double resultado = 0;

        switch (operacion) {
            case "Suma":
                resultado = num1+num2;
                break;

            case "Resta":
                resultado = num1-num2;
                break;

            case "Multiplicación":
                resultado = num1*num2;
                break;
            
            case "División":
                if(num2 == 0){
                    Alert alerta2 = new Alert(Alert.AlertType.ERROR);
                    alerta2.setHeaderText(null);
                    alerta2.setTitle("ERROR");
                    alerta2.setContentText("Error!!, el número dos (2) debe ser diferente de 0...");
                    alerta2.showAndWait();
                }else{
                    resultado = (double)num1/num2;
                }
                
                break;

            default:
                txt_Salida.setText("Error desconocido, intente de nuevo");
                break;
        }
        if(rdb_0dec.isSelected()){formato = String.format("%.0f", resultado);}
        else if(rdb_2dec.isSelected()){formato = String.format("%.2f", resultado);}
        else if(rdb_3dec.isSelected()){formato = String.format("%.3f", resultado);}
        txt_Salida.setText(formato);
    }

    @FXML
    void Saludar(ActionEvent event) {
        String nom = txt_nombre.getText();
        /* op.addAll(nom);                   //Agregar un nuevo elemento a la lista
        cbx_Operaciones.setItems(op); */  //Insertar la lista al combo box

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Bienvenido");
        alerta.setContentText("Bienvenido "+ nom +"!!");
        alerta.showAndWait();


    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbx_Operaciones.setItems(op);
        cbx_Operaciones.getSelectionModel().selectFirst();
        
        ToggleGroup decimal = new ToggleGroup();
        rdb_0dec.setToggleGroup(decimal);
        rdb_2dec.setToggleGroup(decimal);
        rdb_3dec.setToggleGroup(decimal);
        rdb_0dec.setSelected(true);
    }

}