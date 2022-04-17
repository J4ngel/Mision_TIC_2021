import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    String credenciales[] = {"Jaime", "123456"};
    @FXML
    private Button btn_login;

    @FXML
    private TextField campo_usuario;

    @FXML
    private PasswordField campo_contrasena;

    @FXML
    void fase_login(ActionEvent event) {
        String usuario = campo_usuario.getText();
        String pass = campo_contrasena.getText();

        if(usuario.equals(credenciales[0]) && pass.equals(credenciales[1])){
            JOptionPane.showMessageDialog(null, ("Hola "+usuario+" se ha logueado con exito"), "Login", JOptionPane.INFORMATION_MESSAGE);
        }else{ JOptionPane.showMessageDialog(null, "Error credenciales no validas","ERROR", JOptionPane.ERROR_MESSAGE);}
    }

}

