import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class interfaz_controller {

    @FXML
    private Button btn_calcular;

    @FXML
    private TextField txt_registros;

    @FXML
    private TextArea txt_entrada;

    @FXML
    private TextArea txt_salida;

    @FXML
    void Calcular(ActionEvent event) {
        String registros = txt_registros.getText();
        String datos = txt_entrada.getText();

        SchoolGradingSystem grupo_x = new SchoolGradingSystem();
        grupo_x.loadData(registros, datos);
        //String mensaje = grupo_x.stat1()+"\n"+grupo_x.stat2()+"\n"+grupo_x.stat3()+"\n"+grupo_x.stat4();
        String mensaje = String.format("%.2f\n%d\n%s\n%s",grupo_x.stat1(),grupo_x.stat2(),grupo_x.stat3(),grupo_x.stat4());
        txt_salida.setText(mensaje);
    }

}
