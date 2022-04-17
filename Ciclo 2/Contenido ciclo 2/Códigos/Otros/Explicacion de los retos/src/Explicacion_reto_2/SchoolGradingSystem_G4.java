package Explicacion_reto_2;

import java.util.Scanner;

public class SchoolGradingSystem_G4 {
    private String Nombres[] = {"armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    private String Materias[] = {"geografia","matematicas","informatica"};
    //private String Gerero[] = {"m","m","m","f","f","f"};
    private double Notas[][];

    public SchoolGradingSystem_G4() {
        Notas = new double[Nombres.length][Materias.length];
    }

    public void readData(){
        Scanner leer = new Scanner(System.in);
        int registros = Integer.parseInt(leer.nextLine());

        for(int i = 0; i < registros; i++){
            String linea[] = leer.nextLine().split(" ");
            int nombre = (int)(Double.parseDouble(linea[0]));
            int materia = (int)Double.parseDouble(linea[2]);

            Notas[nombre-1][materia-1] = Double.parseDouble(linea[3]);
        }

        leer.close();
    }

    public double question1(){
        return 0.1;
    }
    public int question2(){
        return 1;
    }
    public String question3(){
        return Materias[0];
    }
    public String question4(){
        double nota_mayor = Notas[0][0];
        int estudiante = 0;
        for(int i = 0; i < Nombres.length; i++){
            if(nota_mayor < Notas[i][0]){
                nota_mayor = Notas[i][0];
                estudiante = i;
            }
        }
        return Nombres[estudiante];
    }

    public double[][] getNotas() {
        return Notas;
    }

    public void setNotas(double[][] notas) {
        Notas = notas;
    }
}
