import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("interfaz.fxml"));
       Parent root = fxmlloader.load();
       Scene ventana = new Scene(root);
       
       primaryStage.setTitle("Prototipo 1 - Calculadora");
       primaryStage.setScene(ventana);
       primaryStage.show();
    }
}