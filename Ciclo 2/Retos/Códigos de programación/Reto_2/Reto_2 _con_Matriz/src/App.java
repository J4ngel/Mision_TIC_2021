import java.util.Scanner;

public class App {
    static Grupo grupo_A = new Grupo();
    public static void main(String[] args) throws Exception {
        String nombres[] = {"armando","nicolas","daniel","maria","marcela","alexandra"};
        String materias[] = {"geografia","matematicas","informatica"};
        
        for (String estudiante : nombres) {grupo_A.setNombres(estudiante);}
        for (String clase : materias) {grupo_A.setMaterias(clase);}

        String linea[] = new String[4];
        //Comienzo y procesamiento de datos
        Scanner sc = new Scanner(System.in);
        
        int registros = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i <registros; i++){
            linea = sc.nextLine().split(" ");
    
            int estudiante = ((int)(Double.parseDouble(linea[0])))-1;
            int materia = ((int)(Double.parseDouble(linea[2])))-1;
            double nota = Double.parseDouble(linea[3]);
            grupo_A.setNotas(estudiante, materia, nota);
        }    
        sc.close();
        //Salidas
        System.out.printf("%.2f\n",question1());
        System.out.println(question2());
        System.out.println(question3());
        System.out.println(question4());
    }

    public static double question1(){
        double prom_aprobados = 0;

        for (double[] estudiante : grupo_A.getNotas()) {
            for (double nota : estudiante) {
                if(nota > 2.5 && nota<=5){prom_aprobados++;}
            }            
        }
        return prom_aprobados/(grupo_A.getNotas().length*grupo_A.getNotas()[0].length);
    }

    public static int question2(){
        int insuficientes = 0;

        for (double[] estudiante : grupo_A.getNotas()) {
            for (double nota : estudiante) {
                if(nota > 1 && nota<=2.5){insuficientes++;}
            }            
        }
        return insuficientes;
    }
    public static String question3(){
        double prom[] = new double[grupo_A.getMaterias().size()];
        for(int i = 0; i < prom.length; i++){prom[i] = 0;}

        for (int i = 0; i < grupo_A.getNotas()[0].length; i++) {
            for (int j = 0; j < (grupo_A.getNotas().length-3); j++) {
                    prom[i] += grupo_A.getNotas(j, i);
            }
            prom[i] /= 3;
        }
        
        int materia = 0;
        double menor = prom[0];
        for (int i = 0; i< prom.length; i++) {
            if(menor > prom[i]) {
                materia = i;
                menor = prom[i];
            }
        }

        return grupo_A.getMaterias(materia);
    }

    public static String question4(){
        int estudiante = 0;
        double mayor = grupo_A.getNotas(0,0);

        for(int i=0; i < grupo_A.getNotas().length; i++){
            if(mayor < grupo_A.getNotas(i,0)){
                estudiante = i;
                mayor = grupo_A.getNotas(i,0);
            }
        }
        return grupo_A.getNombres(estudiante);
    }
}
