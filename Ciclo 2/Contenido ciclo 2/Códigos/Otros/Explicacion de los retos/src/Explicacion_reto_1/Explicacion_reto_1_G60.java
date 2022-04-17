package Explicacion_reto_1;

import java.util.Scanner;

public class Explicacion_reto_1_G60 {
    public static void main(String[] args){
        //---------Variables a usar
        Scanner leer = new Scanner(System.in);
        String mensaje = "";
        double promedio_1 = 0, promedio_2 = 0;
        int inviables = 0;
        
        /* Double n1;
        double n2;
        n1 = (int)(7);
        n2 = (int)(7); */
        //-------->Lectura de datos
        int tam = Integer.parseInt(leer.nextLine());
        double D_IRCA[] = new double[tam];

        String lectura[] = leer.nextLine().split(" ");
        for(int i=0; i<tam; i++){
            lectura[i] = lectura[i].replace(",", ".");
            D_IRCA[i] = Double.parseDouble(lectura[i]);
        }
        //------------>Procesamiento de datos
        for(int i=0; i<tam; i++){
            promedio_1 = promedio_1 + D_IRCA[i];

            if(D_IRCA[i] >= 80.1 & D_IRCA[i] <= 100){
                inviables++;
            }else if(D_IRCA[i] >= 5.1 & D_IRCA[i] <= 35){
                promedio_2 = promedio_2 +1;
            }
        }
        promedio_1 = promedio_1/tam;

        if(promedio_1 >= 80.1 & promedio_1 <=100){
            mensaje = "INVIABLE SANITARIAMENTE";
        }else if(promedio_1 >= 35.1 & promedio_1 <=80){
            mensaje = "ALTO";
        }else if(promedio_1 >= 14.1 & promedio_1 <=35){
            mensaje = "MEDIO";
        }else if(promedio_1 >= 5.1 & promedio_1 <=14){
            mensaje = "BAJO";
        }else if(promedio_1 >= 0 & promedio_1 <=5){
            mensaje = "SIN RIESGO";
        }

        promedio_2 = (promedio_2*100)/tam;


        //-------->Salidas
        System.out.println(mensaje);    //
        System.out.printf("%.2f\n",promedio_2);    //
        if(inviables > 1){System.out.println("SI");}
        else{System.out.println("NO");}
        leer.close();
    }
}
