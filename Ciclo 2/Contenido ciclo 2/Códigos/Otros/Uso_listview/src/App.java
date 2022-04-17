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
        FXMLLoader file = new FXMLLoader(getClass().getResource("Prueba_listv.fxml"));
        Parent root = file.load();
        Scene frame = new Scene(root);
        primaryStage.setTitle("Prueba listview");
        primaryStage.setScene(frame);
        primaryStage.show();
    }
}
