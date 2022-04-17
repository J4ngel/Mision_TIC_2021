
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Iniciar_sesion {

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_usuario;

    @FXML
    private ComboBox<String> cbx_rol;

    @FXML
    private Button btn_log;

    @FXML
    void login(ActionEvent event) {
        String usuario = txt_usuario.getText();
        String clave = txt_password.getText();
        String rol = cbx_rol.getValue(); //Agarrar el valor que uno tenga seleccionado

        if(usuario.equalsIgnoreCase("Jaime") && clave.equals("123456")){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Login");
            alerta.setContentText("Usted Ingresó correctamente, bienvenido "+ rol);
            alerta.showAndWait();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Credenciales no validas!!");
            alerta.showAndWait();
        }
    }

    public void initialize(){
        cbx_rol.getItems().removeAll(cbx_rol.getItems());
        cbx_rol.getItems().addAll("Administrador", "Ingeniero", "Operario", "Administrativo");
        cbx_rol.getSelectionModel().select("Ingeniero");

    }
}
