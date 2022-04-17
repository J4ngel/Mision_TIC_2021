

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login_controller {

    @FXML
    private Label txt_error;

    @FXML
    private Button btn_login;

    @FXML
    private TextField txt_user;

    @FXML
    private PasswordField txt_pass;

    @FXML
    void Login(ActionEvent event) throws IOException {
        String user = txt_user.getText();
        String pass = txt_pass.getText();
        String error = "";

        if(user.equalsIgnoreCase("prueba")){
            error = "Usuario no valido !!";
        } else if(pass.length() < 6){
            error = "La contraseña debe tener mas de 6 caracteres !!";
        } else if (pass.equalsIgnoreCase(user)){
            error = "La contraseña no debe ser igual al usuario !!";
        }

        if(error.isEmpty()){
            Stage frame1 = (Stage) btn_login.getScene().getWindow();
            frame1.close();

            FXMLLoader file2 = new FXMLLoader(getClass().getResource("/Vistas/Inicio.fxml"));
            Parent root2 = file2.load();
            Scene frame2 = new Scene(root2);
            Stage secondStage = new Stage();
            secondStage.setTitle("Bienvenido");
            secondStage.setScene(frame2);
            secondStage.show();
        }else{
            txt_error.setText(error);
        }
    }
}
