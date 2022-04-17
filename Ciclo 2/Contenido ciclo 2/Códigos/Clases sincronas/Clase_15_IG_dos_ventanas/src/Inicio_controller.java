import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Inicio_controller {

    @FXML
    private Button btn_volver;

    @FXML
    void Cerrar_Sesion(ActionEvent event) throws IOException {
        Stage frame2 = (Stage) btn_volver.getScene().getWindow();
        frame2.close();

        FXMLLoader file1 = new FXMLLoader(getClass().getResource("/Vistas/Login.fxml"));
        Parent root1 = file1.load();
        Scene frame1 = new Scene(root1);
        Stage secondStage = new Stage();
        secondStage.setTitle("Bienvenido");
        secondStage.setScene(frame1);
        secondStage.show();
    }

}