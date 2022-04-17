import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//Las importaciones comentareadas solo son requeridas para cuado se ejecuta el programa hecho a pedal
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //A Pedal
        /* primaryStage.setTitle("Prueba1");
        Button boton = new Button("Clickeame");
        boton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
               System.out.println("HOlA!!! uwu");
                
            }
            
        });
        
        StackPane root = new StackPane();
        root.getChildren().addAll(boton);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show(); */


        //Usando el Scene builder
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout.fxml"));
        Parent root = fxmlLoader.load();
        Scene ventana = new Scene(root);
        primaryStage.setTitle("Prueba 2");
        primaryStage.setScene(ventana);
        primaryStage.show();
    }
}
