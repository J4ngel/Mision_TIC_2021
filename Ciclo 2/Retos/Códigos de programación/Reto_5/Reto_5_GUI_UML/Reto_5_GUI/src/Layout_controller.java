import Clases.SchoolGradingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Layout_controller {
    Alert error = new Alert(Alert.AlertType.ERROR);
    @FXML
    private TextField txt_n_registros;

    @FXML
    private TextArea txt_entrada;

    @FXML
    private Button btn_calcular;

    @FXML
    private TextArea txt_salida;

    @FXML
    private Button btn_limpiar;

    @FXML
    void Calcular(ActionEvent event) {
        if(txt_n_registros.getText().equals("") || txt_entrada.getText().equals("")){Error("Error algunos campos están vacios");}
        else{
            SchoolGradingSystem grupo_A = new SchoolGradingSystem();
            grupo_A.loadData(txt_entrada.getText().split("\n"), Integer.parseInt(txt_n_registros.getText()));
            txt_salida.setText(String.format("%.2f\n%d\n%s\n%s",grupo_A.stat1(),grupo_A.stat2(),grupo_A.stat3(),grupo_A.stat4()));
        }
    }

    @FXML
    void Limpiar(ActionEvent event) {
        txt_n_registros.setText("");
        txt_entrada.setText("");
        txt_salida.setText("");
    }

    void Error(String mensaje){
        error.setHeaderText(null);
        error.setTitle("ERROR");
        error.setContentText(mensaje);
        error.showAndWait();
    }
}
