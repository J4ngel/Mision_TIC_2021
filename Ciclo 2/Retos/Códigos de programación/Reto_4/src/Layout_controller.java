import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Clases.*;

public class Layout_controller implements Initializable{
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert info = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_materia;

    @FXML
    private TextField txt_nota;

    @FXML
    private ChoiceBox<String> chb_genero;
    private ObservableList<String> op_genero = FXCollections.observableArrayList();

    @FXML
    private Button btn_guardar;

    @FXML
    private Button btn_limpiar_1;

    @FXML
    private Button btn_cargar;

    @FXML
    private Button btn_procesar;

    @FXML
    private Button btn_limpiar_2;

    @FXML
    private TextArea txt_carga;

    @FXML
    private TextArea txt_procesar;

    @FXML
    private TextField txt_busqueda_nombre;

    @FXML
    private TextField txt_busqueda_materia;

    @FXML
    private Button btn_consultar;

    @FXML
    private Button btn_eliminar;

    @FXML
    private TextArea txt_salida_consulta;

    //-------->ATRIBUTOS PROPIOS
    Connect conexion_1 = new Connect();
    Connection conn = conexion_1.conexion();
    String sql;
    PreparedStatement ps;
    String sql_temp;
    PreparedStatement ps_temp;
    int id_estudiante;
    int id_materia;
    //-------------->METODOS ESPECIFICOS
    private void alerta_e(String mensaje){
        error.setHeaderText(null);
        error.setTitle("ERROR");
        error.setContentText(mensaje);
        error.showAndWait();
    }

    private void alerta_i(String titulo, String mensaje){
        info.setHeaderText(null);
        info.setTitle(titulo);
        info.setContentText(mensaje);
        info.showAndWait();
    }

    private String valor_id(String tabla, String campo, int id){
        sql_temp = "SELECT "+campo+" FROM "+tabla+" WHERE id = ?";
        try{
            ps_temp = conn.prepareStatement(sql_temp);
            ps_temp.setInt(1, id);
            ResultSet result = ps_temp.executeQuery();
            if(result.next()) {return result.getString(1);}
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return "";
    }

    private int existe_id(String tabla, String campo, String valor){
        sql_temp = "SELECT id FROM "+tabla+" WHERE "+campo+" = ?";
        try{
            ps_temp = conn.prepareStatement(sql_temp);
            ps_temp.setString(1, valor);
            ResultSet result = ps_temp.executeQuery();
            if(result.next()) {return result.getInt(1);}
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private int last_id(PreparedStatement ps){
        try{
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                int last_inserted_id = rs.getInt(1);
                return last_inserted_id;
            }
        }catch(SQLException e){
            alerta_e(e.getMessage());
        }
        return -1;
    }

    //----------------->EVENTOS
    @FXML
    void Cargar(ActionEvent event) {
        sql = "SELECT * FROM Notas";
        try{
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            String salida = "";
            if(result.isClosed()){txt_carga.setText("No hay alumnos registrados");}
            else{
                while(result.next()){
                    id_estudiante = result.getInt(2);
                    id_materia    = result.getInt(3);
                    
                    salida += id_estudiante+".0 "+valor_id("Estudiantes","Genero",id_estudiante)+".0 "+id_materia+".0 "+result.getDouble(4)+"\n";
                }        
                txt_carga.setText(salida);
            }
        }catch(SQLException e){
            alerta_e("Error al cargar los datos: "+e.getMessage());
        }
    }

    @FXML
    void Procesar(ActionEvent event) {
        if(txt_carga.getText().equals("")){alerta_i("Falta cargar los datos", "Para poder procesar los datos, primero debe cargarlos (usar el botón cargar)");}
        else{
            if(txt_carga.getText().equals("No hay alumnos registrados")){txt_procesar.setText("No hay alumnos registrados");}
            else{
                try{
                    ResultSet result, rs;
                    //Promedio aprobados
                    sql = "SELECT COUNT(*) FROM Notas WHERE Nota <= 5 and Nota > 2.5";
                    sql_temp = "SELECT COUNT(*) FROM Notas";
                    ps = conn.prepareStatement(sql);
                    ps_temp = conn.prepareStatement(sql_temp);
                    result = ps.executeQuery();
                    rs = ps_temp.executeQuery();

                    double aprobados = result.getInt(1);
                    double n_registros = rs.getInt(1);

                    //Cantidad insuficientes
                    sql = "SELECT COUNT(*) FROM Notas WHERE Nota <= 2.5 and Nota > 1";
                    ps = conn.prepareStatement(sql);
                    result = ps.executeQuery();
                    int insuficientes = result.getInt(1);

                    //Peor materia 
                    String Materia = "";
                    sql = "SELECT avg(Nota) AS promedio, Materia FROM Notas, Materias  INNER JOIN Estudiantes ON Estudiantes.id = Notas.id_estudiante AND Materias.id = Notas.id_materia WHERE Estudiantes.Genero = 0 GROUP BY id_materia ORDER BY promedio ASC LIMIT 1";
                    ps = conn.prepareStatement(sql);
                    result = ps.executeQuery();
                    Materia = result.getString(2);

                    //Mejor nota en geografia
                    int id_geo = existe_id("Materias", "Materia", "geografia");
                    String Nombre;
                    if(id_geo == 0){Nombre = "Ningun estudiante está cursando\ngeografia actualmente";}
                    else{
                        sql = "SELECT MAX(Nota),Nombre FROM Notas, Materias INNER JOIN Estudiantes ON Estudiantes.id = Notas.id_estudiante AND Materias.id = Notas.id_materia WHERE Materia = 'geografia'";
                        ps = conn.prepareStatement(sql);
                        result = ps.executeQuery();
                        Nombre = result.getString(2);
                    }

                    //Salida
                    String salida = String.format("%.2f\n%d\n%s\n%s",(aprobados/n_registros), insuficientes, Materia, Nombre);
                    txt_procesar.setText(salida);
                }catch(SQLException e){
                    alerta_e("Error al tratar de procesar: "+e.getMessage());
                    System.out.println(e.getMessage());
                }   
            }
        } 
    }

    @FXML
    void Consultar(ActionEvent event) {
        String nombre = txt_busqueda_nombre.getText();
        String materia = txt_busqueda_materia.getText();
        
        if(nombre.isEmpty() && materia.isEmpty()){alerta_e("Para cosultar registros se requiere al menos el nombre y/o la materia !!");}
        else{
            if(!nombre.isEmpty() && !materia.isEmpty()){
                sql = "SELECT * FROM Notas WHERE (id_estudiante = ? AND id_materia = ?)";
            }
            else if(!nombre.isEmpty()){
                sql = "SELECT * FROM Notas WHERE id_estudiante = ?";
            }else{
                sql = "SELECT * FROM Notas WHERE id_materia = ?";
            }
                  
            try{
                ps = conn.prepareStatement(sql);
    
                if(!materia.isEmpty() && !nombre.isEmpty()) {
                    ps.setInt(1, existe_id("Estudiantes", "Nombre", nombre));
                    ps.setInt(2, existe_id("Materias", "Materia", materia));
                }else if(!nombre.isEmpty()){
                    ps.setInt(1, existe_id("Estudiantes", "Nombre", nombre));
                }else if(!materia.isEmpty()){
                    ps.setInt(1, existe_id("Materias", "Materia", materia));
                }
                
    
                ResultSet result = ps.executeQuery();
                String salida = "";
                if(result.isClosed()){txt_salida_consulta.setText("No se encontraron resultados");}
                else {
                    while(result.next()){
                        id_estudiante = result.getInt(2);
                        id_materia    = result.getInt(3);
    
                        String genero = "";
                        if(valor_id("Estudiantes","Genero",id_estudiante).equals("0")){genero = "M";}
                        else{genero = "F";}
    
                        salida += "| Nombre: "+valor_id("Estudiantes","Nombre",id_estudiante)+" | Genero: "+genero+" | Materia: "+valor_id("Materias","Materia",id_materia)+" | Nota: "+result.getDouble(4)+" |\n";
                    }        
                    txt_salida_consulta.setText(salida);
                }
    
            }catch(SQLException e){
                alerta_e("Error al consultar datos: "+e.getMessage());
            }
        }
    }

    @FXML
    void Eliminar(ActionEvent event) {
        String nombre = txt_busqueda_nombre.getText();
        String materia = txt_busqueda_materia.getText();
        
        if(nombre.isEmpty() && materia.isEmpty()){
            alerta_e("Para eliminar registros se requiere al menos el nombre y/o la materia !!");
        }
        else{
            if(!nombre.isEmpty() && !materia.isEmpty()){
                sql = "DELETE FROM Notas WHERE (id_estudiante = ? AND id_materia = ?)";
            }
            else if(!nombre.isEmpty()){
                sql = "DELETE FROM Notas WHERE id_estudiante = ?";
            }else{
                sql = "DELETE FROM Notas WHERE id_materia = ?";
            }

            try{
                ps = conn.prepareStatement(sql);
                int id_est = 0, id_mat = 0;
                boolean borrar = true;
                if(!materia.isEmpty() && !nombre.isEmpty()) {
                    id_est = existe_id("Estudiantes", "Nombre", nombre);
                    id_mat = existe_id("Materias", "Materia", materia);
                    if(id_est == 0 && id_mat == 0){borrar = false;}
                    else{
                        ps.setInt(1, id_est);
                        ps.setInt(2, id_mat);
                    }

                }else if(!nombre.isEmpty()){
                    id_est = existe_id("Estudiantes", "Nombre", nombre);
                    ps.setInt(1, id_est);
                    if(id_est == 0){borrar = false;}
                    else{
                        sql_temp = "DELETE FROM Estudiantes WHERE Nombre = ?";
                        ps_temp = conn.prepareStatement(sql_temp);
                        ps_temp.setString(1, nombre);
                        ps_temp.executeUpdate();
                    }
                    
                }else{
                    id_mat = existe_id("Materias", "Materia", materia);
                    ps.setInt(1, id_mat);
                    if(id_mat == 0){borrar = false;}
                    else{
                        sql_temp = "DELETE FROM Materias WHERE Materia = ?";
                        ps_temp = conn.prepareStatement(sql_temp);
                        ps_temp.setString(1, materia);
                        ps_temp.executeUpdate();
                    }
                    
                }
                if(borrar){
                    ps.executeUpdate();
                    alerta_i("Información","Se eliminó el registro exitosamente");
                }else{
                    alerta_e("El nombre y/o materia digitados no existe!!");
                }
                   
            }catch(SQLException e){
                alerta_e("Error al consultar datos: "+e.getMessage());
            }
        }
    }

    @FXML
    void Guardar(ActionEvent event) {
        String nombre   = txt_nombre.getText();
        String materia  = txt_materia.getText();
        String nota_t   = txt_nota.getText();
        Double nota;
        int genero;

        if(nombre.isEmpty() || materia.isEmpty() || chb_genero.getValue().equals("-") || nota_t.isEmpty()){
            alerta_e("Hay campos sin llenar, por favor verifique su entrada");
        }else{
            nota = Double.parseDouble(txt_nota.getText().replaceAll(",", ".").replaceAll(" ", ""));
            if(nota > 5 || nota < 0){alerta_e("Error, la nota digitada debe estan entre el rango de 0 a 5");}
            else{
                if(chb_genero.getValue().equals("F")){genero = 1;}
                else{genero = 0;}

                try{
                    id_estudiante = existe_id("Estudiantes", "Nombre", nombre);
                    id_materia    = existe_id("Materias", "Materia", materia);
                    if(id_estudiante == 0){
                        sql = "INSERT INTO Estudiantes(Nombre, Genero) VALUES(?, ?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nombre);
                        ps.setInt(2, genero);
                        ps.executeUpdate();
                        id_estudiante = last_id(ps); 
                    }
                    if(id_materia == 0){
                        sql = "INSERT INTO Materias(Materia) VALUES(?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, materia);
                        ps.executeUpdate();
                        id_materia = last_id(ps);
                    }
                    sql = "INSERT INTO Notas(id_estudiante, id_materia, Nota) VALUES(?,?,?)";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, id_estudiante);
                    ps.setInt(2, id_materia);
                    ps.setDouble(3, nota);
                    ps.executeUpdate();
                    alerta_i("Información", "Estudiante guardado con exito !!");
                }catch(SQLException e){
                    alerta_e("Error al crear el estudiante: "+e.getMessage());
                }
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        op_genero.addAll("-","F","M");
        chb_genero.setItems(op_genero);
        chb_genero.getSelectionModel().select(0);
    }
    
    @FXML
    void Limpiar_campos(ActionEvent event) {
        txt_nombre.setText("");
        txt_materia.setText("");
        txt_nota.setText("");
        chb_genero.getSelectionModel().select(0);
        txt_carga.setText("");
        txt_procesar.setText("");
        txt_busqueda_nombre.setText("");
        txt_busqueda_materia.setText("");
        txt_salida_consulta.setText("");
    }
}