import java.util.Scanner;

public class reto1 {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        String Nombres[]  = {"armando","nicolas","daniel","maria","marcela","alexandra"};
        String Materias[] = {"geografia","matematicas","informatica"};
        int genero[]      = {0,0,0,1,1,1}; 
        double Datos[][]  = new double[6][3], mejor_geo[] = {0,-1}, peor_prom[] = {0,6}, prom[] = {0,0,0};
        //------->Lectura de datos de la tabla
        int registros,aprobados = 0, insuficientes = 0;
        registros = Integer.parseInt(leer.nextLine());
        String linea[] = new String[4];
        for(int i=0;i<registros;i++){
            //Nombre | genero | materia | calificación
            linea = leer.nextLine().split(" ");
            //Estudiante
            int estudiante = (int)(Double.parseDouble(linea[0]))-1; //int estudiante = ((int) Math.round(Double.parseDouble(linea[0])))-1;
            int materia    = (int)(Double.parseDouble(linea[2]))-1; //int materia = ((int) Math.round(Double.parseDouble(linea[2])))-1;
            Datos[estudiante][materia] = Double.parseDouble(linea[3]);
            //Clasificación aprobados/insuficientes
            if (Datos[estudiante][materia] > 2.5 & Datos[estudiante][materia] <= 5.0)     {aprobados++;}
            else if (Datos[estudiante][materia] > 1 & Datos[estudiante][materia] <= 2.5)  {insuficientes++;}
            //Materia con peor promedio del genero m, sumatoria:
            if(genero[estudiante] == 0){prom[materia] += Datos[estudiante][materia];}
            //Mejor desempeño en geografía
            if(materia == 0){
                if(mejor_geo[1] < Datos[estudiante][materia]){
                    mejor_geo[0] = estudiante;
                    mejor_geo[1] = Datos[estudiante][materia];
                }
            }
        }
        //Calculo del promedio
        for(int i=0; i<3;i++){
            prom[i] /=3;
            if (peor_prom[1] > prom[i]){
                peor_prom[0] = i; 
                peor_prom[1] = prom[i];
            }
        }
        //------------->PRESENTACION DE DATOS<-------------
        double p_aprobacion = aprobados;
        p_aprobacion /= registros;
        System.out.printf("%.2f\n",p_aprobacion);
        System.out.println(insuficientes);
        System.out.println(Materias[(int)(peor_prom[0])]);
        System.out.println(Nombres[(int)(mejor_geo[0])]);
        leer.close();
        //for (double fila[] : Datos) {System.out.printf("| ");for (double nota : fila){System.out.printf("%.1f |",nota);}System.out.println();}//---------->Imprimir tabla
    }
}