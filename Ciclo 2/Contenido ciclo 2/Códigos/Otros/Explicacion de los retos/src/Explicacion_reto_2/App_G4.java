package Explicacion_reto_2;

public class App_G4 {
    public static void main(String[] args) {
        
        SchoolGradingSystem_G4 curso_1 = new SchoolGradingSystem_G4(); 
        curso_1.readData();
        System.out.println("Falta programar question 1");
        System.out.println("Falta question 2");
        System.out.println(curso_1.question3());  //Falta hacer el question3 pero así se debe llamar
        System.out.println(curso_1.question4());
         
        // Para ver graficamente como se guardaron los datos
        /* double notas[][] = curso_1.getNotas(); for (int i=0; i<6; i++){
        System.out.print("|"); for(int j=0; j<3; j++){
        System.out.printf("\t%.2f\t|",notas[i][j]); } System.out.println(); } */
    }
}
