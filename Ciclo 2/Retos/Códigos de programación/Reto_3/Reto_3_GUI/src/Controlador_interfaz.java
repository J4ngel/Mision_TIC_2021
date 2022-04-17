import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controlador_interfaz {

    @FXML
    private TextField Campo_numero_registros;

    @FXML
    private TextArea Campo_datos_entrada;

    @FXML
    private TextArea Campo_salida;

    @FXML
    private Button btn_calcular;

    @FXML
    void Calcular_resultados(ActionEvent event) {
        SchoolGradingSystem grupo_1 = new SchoolGradingSystem();

        int registros = Integer.parseInt(Campo_numero_registros.getText());
        String datos = Campo_datos_entrada.getText();
        String lineas[] = datos.split("\n");
        
        grupo_1.loadData(lineas, registros);

        String salida = String.format("%.2f\n%d\n%s\n%s",grupo_1.stat1(),grupo_1.stat2(),grupo_1.stat3(),grupo_1.stat4());
        Campo_salida.setText(salida);
    }

}
