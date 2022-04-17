import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Calculadora {
    String captura="", mostrar="",operacion="";

    @FXML
    private TextField txt_pantalla;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_punto;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_igual;

    @FXML
    private Button btn_suma;

    @FXML
    private Button Btn_resta;

    @FXML
    private Button btn_multiplicar;

    @FXML
    private Button btn_div;

    @FXML
    private RadioButton rdb_0dec;

    @FXML
    private ToggleGroup formato_salida;

    @FXML
    private RadioButton rdb_2dec;

    @FXML
    private RadioButton rdb_3dec;

    @FXML
    private Button btn_borrar;

    @FXML
    private Button btn_borrarTodo;

    @FXML
    void Borrar(ActionEvent event) {
        String temp[] = captura.split("");
        captura = "";
        String temp2[] = mostrar.split("");
        mostrar = ""; 
        for(int i = 0; i< temp.length-1; i++) {
            captura += temp[i];
            mostrar += temp2[i];
        }
        
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void BorrarTodo(ActionEvent event) {
        captura = mostrar = operacion = "";
        txt_pantalla.setText("0");
    }

    @FXML
    void Calcular(ActionEvent event) {
        String formato = "%.0f";
        if(rdb_0dec.isSelected()){formato = "%.0f";}
        else if(rdb_2dec.isSelected()){formato = "%.2f";}
        else if(rdb_3dec.isSelected()){formato = "%.2f";}
        
        String temp[] = captura.split(";");
        double numeros[] = new double[temp.length];
        if(temp.length == 1 && temp[0].equals("")){temp[0] = "0";}
        for (int i=0; i<temp.length; i++) {numeros[i] = Double.parseDouble(temp[i]);}

        switch (operacion) {
            case "+":
                for (int i=1; i<numeros.length; i++) {numeros[0] += numeros[i];}
                formato = String.format(formato, numeros[0]);
                txt_pantalla.setText(formato);
                break;
            
            case "-":
                for (int i=1; i<numeros.length; i++) {numeros[0] -= numeros[i];}
                formato = String.format(formato, numeros[0]);
                txt_pantalla.setText(formato);
                break;
                
            case "*":
                for (int i=1; i<numeros.length; i++) {numeros[0] *= numeros[i];}
                formato = String.format(formato, numeros[0]);
                txt_pantalla.setText(formato);
                break;
            
            case "/":
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                boolean sw = true;
                for (int i=1; i<numeros.length; i++) {
                    if(numeros[i]==0){
                        alerta.setHeaderText(null);
                        alerta.setTitle("ERROR");
                        alerta.setContentText("El denominador debe ser difernete de 0!!");
                        alerta.showAndWait();
                        sw = false;
                        break;
                    }else{numeros[0] /= numeros[i];}
                }
                if(sw){
                    formato = String.format(formato, numeros[0]);
                    txt_pantalla.setText(formato);
                }else{txt_pantalla.setText("Sintaxis error!!");}
                break;

            default:
                break;
        }
        captura = mostrar =operacion = "";
    }

    @FXML
    void Cero(ActionEvent event) {
        captura += "0";
        mostrar += "0";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Cinco(ActionEvent event) {
        captura += "5";
        mostrar += "5";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Cuatro(ActionEvent event) {
        captura += "4";
        mostrar += "4";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Division(ActionEvent event) {
        operacion = "/";
        captura +=";";
        mostrar += operacion;
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Dos(ActionEvent event) {
        captura += "2";
        mostrar += "2";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Multiplicar(ActionEvent event) {
        operacion = "*";
        captura += ";";
        mostrar += operacion;
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Nueve(ActionEvent event) {
        captura += "9";
        mostrar += "9";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Ocho(ActionEvent event) {
        captura += "8";
        mostrar += "8";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Punto(ActionEvent event) {
        if(captura.equals("")){
            captura += "0";
            mostrar += "0";
        }
        captura += ".";
        mostrar += ".";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Resta(ActionEvent event) {
        operacion = "-";
        captura += ";";
        mostrar += operacion;
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Seis(ActionEvent event) {
        captura += "6";
        mostrar += "6";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Siete(ActionEvent event) {
        captura += "7";
        mostrar += "7";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Suma(ActionEvent event) {
        operacion = "+";
        captura += ";";
        mostrar += operacion;
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Tres(ActionEvent event) {
        captura += "3";
        mostrar += "3";
        txt_pantalla.setText(mostrar);
    }

    @FXML
    void Uno(ActionEvent event) {
        captura += "1";
        mostrar += "1";
        txt_pantalla.setText(mostrar);
    }
}