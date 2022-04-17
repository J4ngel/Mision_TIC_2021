import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      FXMLLoader graficos = new FXMLLoader(getClass().getResource("Vistas/layout.fxml"));
        Parent root = graficos.load();
        Scene ventana = new Scene(root);
        primaryStage.setTitle("Sistema estadistico");
        primaryStage.setScene(ventana);
        primaryStage.show();
    }
}