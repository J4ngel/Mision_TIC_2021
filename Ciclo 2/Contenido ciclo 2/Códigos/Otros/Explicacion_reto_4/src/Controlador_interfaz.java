import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controlador_interfaz {

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_mat;

    @FXML
    private TextField txt_nota;

    @FXML
    private TextField txt_genero;

    @FXML
    private Button btn_guardar;

    @FXML
    private TextArea C_cargar;

    @FXML
    private TextArea C_procesar;

    @FXML
    private Button btn_cargar;

    @FXML
    private Button btn_procesar;

    @FXML
    private TextField txt_nombre_consulta;

    @FXML
    private TextField txt_materia_consulta;

    @FXML
    private TextArea C_salida_consulta;

    @FXML
    private Button btn_consultar;

    @FXML
    private Button btn_eliminar;

    @FXML
    void Cargar_datos(ActionEvent event) {

        String sql = "select id_estudiante, Genero, id_materia, Nota from Notas inner join info_estudiantes on info_estudiantes.id = Notas.id_estudiante";

        try{
            Connect objconexion = new Connect();
            Connection conn = objconexion.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.isClosed()){C_cargar.setText("No hay datos en la base de datos");}
            else{
                while(rs.next()) {
                    C_cargar.appendText(rs.getString(1)+".0 "+rs.getString(2)+".0 "+rs.getString(3)+".0 "+rs.getString(4)+"\n");
                }
            }

            
        }catch(SQLException e){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText(null);
            error.setTitle("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }
    }

    @FXML
    void Consultar(ActionEvent event) {
        String nombre = txt_nombre_consulta.getText();
        String materia = txt_materia_consulta.getText();
        String mensaje = "";
        String sql = "select Nombre, Genero, Materia, Nota from Notas, info_materias inner join info_estudiantes on Notas.id_estudiante = info_estudiantes.id and Notas.id_materia = info_materias.id where info_estudiantes.Nombre = ?";

        try{
            Connect objconexion = new Connect();
            Connection conn = objconexion.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.isClosed()){mensaje = "No se encontró registro";}
            else{
                while(rs.next()) {
                    mensaje = mensaje +" | " +rs.getString(1)+" | " + rs.getString(2)+" | " +rs.getString(3)+" | " +rs.getString(4)+"\n";
                }
            }
            C_salida_consulta.setText(mensaje);
        }catch(SQLException e){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText(null);
            error.setTitle("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }
    }

    @FXML
    void Eliminar(ActionEvent event) {

    }

    @FXML
    void Guardar_estudiante(ActionEvent event) {
        String nombre = txt_nombre.getText();
        String materia = txt_mat.getText();
        String genero = txt_genero.getText();
        double nota = Double.parseDouble(txt_nota.getText());

        String sql = "insert into info_estudiantes (Nombre, Genero) values(?,?)";

        try{
            Connect objconexion = new Connect();
            Connection conn = objconexion.conexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            if(genero.equals("f")){ps.setInt(2, 1);}
            else{ps.setInt(2, 0);}
            ps.executeUpdate();

            sql = "insert into info_materias (Materia) values(?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, materia);
            ps.executeUpdate();

            sql = "insert into Notas (id_estudiante,id_materia,Nota) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 7);         //id estudiante
            ps.setInt(2, 4);          // id materia
            ps.setDouble(3, nota);      // nota
            ps.executeUpdate();

            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setHeaderText(null);
            info.setTitle("");
            info.setContentText("El estudiante se guardó con exito");
            info.showAndWait();
        }catch(SQLException e){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText(null);
            error.setTitle("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }
    }

    @FXML
    void Procesar_datos(ActionEvent event) {
        String dato_valido = C_cargar.getText();
        Alert error = new Alert(Alert.AlertType.ERROR);
        if(dato_valido.equals("")){
            error.setHeaderText(null);
            error.setTitle("ERROR");
            error.setContentText("Primero debe cargar los datos");
            error.showAndWait();
        }else if(dato_valido.equals("No hay datos en la base de datos")){
            C_procesar.setText("No hay datos en la base de datos");
        }else{
            //RESPUESTA A MEDIAS 4
            String sql = "select MAX(Nota), Nombre from Notas inner join info_estudiantes on info_estudiantes.id = Notas.id_estudiante";
            try{
                Connect objconexion = new Connect();
                Connection conn = objconexion.conexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if(rs.isClosed()){C_procesar.setText("SI NO ENCUENTRA NADA");}
                else{
                    while(rs.next()) {
                        C_procesar.appendText(rs.getString(2)+"\n");
                    }
                }    
            }catch(SQLException e){
                error.setHeaderText(null);
                error.setTitle("ERROR");
                error.setContentText(e.getMessage());
                error.showAndWait();
            }
        }
    }

}
