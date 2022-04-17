import java.util.Scanner;

public class SchoolGradingSystem {
    private final String Nombres[] = {"armando","nicolas","daniel","maria","marcela","alexandra"};
    private final String Materias[] = {"geografia","matematicas","informatica"};
    
    private double prom_aprobados, peor_prom[] = {0,5.1}, mejor_geo[]={0,-1};
    private int registros,insuficientes;
    
    public SchoolGradingSystem() {
        prom_aprobados =0;
        registros = 0;
        insuficientes = 0;
    }

    public void readData(){
        //Inicializar las variables
        String linea[] = new String[4];
        double prom[] = {0,0,0};
        prom_aprobados = 0;
        peor_prom[0] = 0; peor_prom[1] = 5.1;
        mejor_geo[0] = 0; mejor_geo[1] = -1;
        registros = insuficientes = 0;
        //Comienzo y procesamiento de datos
        Scanner sc = new Scanner(System.in);
        
        registros = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i <registros; i++){
            linea = sc.nextLine().split(" ");
    
           int estudiante = ((int)(Double.parseDouble(linea[0])))-1;
           int materia = ((int)(Double.parseDouble(linea[2])))-1;
           double nota = Double.parseDouble(linea[3]);
            
            //Clasificacion aprobados/insuficientes
            if(nota > 2.5 & nota <= 5.0){prom_aprobados++;}
            else if(nota > 1.0 & nota <= 2.5){insuficientes++;}
            //Materia con peor promedio en el genero m, sumatoria
            if(linea[1].equals("0.0")){prom[materia] += nota;}
            //Mejor desempeño en geografia
            if(materia == 0){
                if(mejor_geo[1] < nota){
                    mejor_geo[1] = nota;
                    mejor_geo[0] = estudiante;
                }
            }
        }
        //Calculo de promedio para cada materia
        for(int i=0; i < 3; i++){
            prom[i] /= 3;
            if(peor_prom[1] > prom[i]){
                peor_prom[1] = prom[i];
                peor_prom[0] = i;
            }
        }
        sc.close();
    }  
    public double question1(){return prom_aprobados/registros;}

    public int question2(){return insuficientes;}

    public String question3(){
        return Materias[(int)(peor_prom[0])];
    }
    public String question4(){return Nombres[(int)(mejor_geo[0])];}
}
