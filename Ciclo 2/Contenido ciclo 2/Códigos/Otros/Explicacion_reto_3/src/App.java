import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        /* SchoolGradingSystem grupo_1 = new SchoolGradingSystem();
        grupo_1.loadData();
        System.out.println(grupo_1.stat1());
        System.out.println(grupo_1.stat2());
        System.out.println(grupo_1.stat3());
        System.out.println(grupo_1.stat4()); */
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader file = new FXMLLoader(getClass().getResource("Interfaz.fxml"));
        Parent root = file.load();
        Scene frame = new Scene(root);
        primaryStage.setTitle("Explicacion reto 3");
        primaryStage.setScene(frame);
        primaryStage.show();
    }
}
