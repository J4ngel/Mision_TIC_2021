import java.util.Scanner;

public class SchoolGradingSystem extends GradingSystem {
    //-------->Constructor
    public SchoolGradingSystem(){
        Estudiantes = new Student[Nombres.length];
    }
    //-------->Metodo especifico
    public void loadData(){
        Scanner sc = new Scanner(System.in);
        int registros = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < Estudiantes.length; i++) {Estudiantes[i] = new Student(Materias.length);}
        for (int i = 0; i < registros; i++) {
            String linea[] = sc.nextLine().split(" ");
            int estudiante = ((int)(Double.parseDouble(linea[0])) -1);
            int materia    = ((int)(Double.parseDouble(linea[2])) -1);
            if(Estudiantes[estudiante].getNombre().equals("")){
                Estudiantes[estudiante].setNombre(Nombres[estudiante]);
                Estudiantes[estudiante].setGenero((int)(Double.parseDouble(linea[1])));
            }
            Estudiantes[estudiante].setNotas(materia, Double.parseDouble(linea[3]));
        }
        sc.close();
    }
}