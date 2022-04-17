import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class frm_control {

    @FXML
    private TextField Campo_n1;

    @FXML
    private TextField Campo_n2;

    @FXML
    private Button btn_calcular;

    @FXML
    private RadioButton rbtn_suma;

    @FXML
    private ToggleGroup Grupo_de_operaciones;

    @FXML
    private RadioButton rbtn_resta;

    @FXML
    private RadioButton rbtn_multi;

    @FXML
    private RadioButton rbtn_division;

    @FXML
    private TextField Campo_salida;

    @FXML
    void Calculo(ActionEvent event) {
        int num1 = Integer.parseInt(Campo_n1.getText());
        int num2 = Integer.parseInt(Campo_n2.getText());
        String salida;

        if(rbtn_suma.isSelected()){
            salida = String.format("%d",num1+num2);
            Campo_salida.setText(salida);
        }else if(rbtn_resta.isSelected()){
            salida = String.format("%d",num1-num2);
            Campo_salida.setText(salida);
        }else if(rbtn_multi.isSelected()){
            salida = String.format("%d",num1*num2);
            Campo_salida.setText(salida);
        }else if(rbtn_division.isSelected()){
            if(num2 != 0){
                salida = String.format("%.2f",(double)num1/num2);
                Campo_salida.setText(salida);
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("ERROR");
                alerta.setContentText("El número 2 debe ser difernete de 0!!");
                alerta.showAndWait();
            }
        }
    }

}
