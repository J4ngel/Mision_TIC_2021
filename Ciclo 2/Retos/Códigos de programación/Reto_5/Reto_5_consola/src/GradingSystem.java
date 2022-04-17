
public class GradingSystem {
    //---------->Atributos
    protected final String Nombres[] = {"armando","nicolas","daniel","maria","marcela","alexandra"};
    protected final String Materias[] = {"geografia","matematicas","informatica"};
    //private Student basura = new Student(1); //No se necesita
    protected Student Estudiantes[];           //Arreglo de estudiantes (Se instancia en SchoolGradingSystem)
    //----------->Metodos especificos
    public double stat1(){
        double prom = 0;
        for (Student estudiante : Estudiantes) {
            for (double nota : estudiante.getNotas()) {
                if(nota > 2.5 && nota<=5){prom++;}
            }
        }
        return prom/(Estudiantes.length*Materias.length);
    }

    public int stat2(){
        int insuficientes = 0; 
        
        for (Student estudiante : Estudiantes) {
            for (double nota : estudiante.getNotas()) {
                if(nota > 1 && nota<=2.5){insuficientes++;}
            }
        }
        return insuficientes;
    }

    public String stat3(){
        double menor_p = 6;
        int materia = 0;
        int c_hombres = 0;
        double prom = 0;
        String mensaje = "";
        
        for (int i = 0; i < Materias.length; i++) {
            prom = 0;
            c_hombres = 0;
            for (int j = 0; j < Estudiantes.length; j++) {
                if(Estudiantes[j].getGenero() == 0){
                    prom += Estudiantes[j].getNotas()[i];
                    c_hombres++;
                }
            }
        
            if(c_hombres == 0){
                mensaje = "No hay hombres registrados";
                break;
            }else{
                prom /= c_hombres;
                if(menor_p > prom){
                    menor_p = prom;
                    materia = i;
                }
            }
        }
        if(mensaje.equals("")){
            mensaje = Materias[materia];
        }
        return mensaje;
    }

    public String stat4(){
        String nombre = Estudiantes[0].getNombre();
        double mayor = Estudiantes[0].getNotas()[0];

        for (Student estudiante : Estudiantes) {
            if(mayor < estudiante.getNotas()[0]){
                mayor = estudiante.getNotas()[0];
                nombre = estudiante.getNombre();
            }
        }
        return nombre;
    }
}