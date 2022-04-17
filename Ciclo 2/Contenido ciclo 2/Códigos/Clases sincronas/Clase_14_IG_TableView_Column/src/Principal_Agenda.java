import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal_Agenda extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader file = new FXMLLoader(getClass().getResource("Agenda.fxml"));
        Parent root = file.load();
        Scene frame = new Scene(root);
        primaryStage.setTitle("Login con imagen");
        primaryStage.setScene(frame);
        primaryStage.show();
    }
    
}
