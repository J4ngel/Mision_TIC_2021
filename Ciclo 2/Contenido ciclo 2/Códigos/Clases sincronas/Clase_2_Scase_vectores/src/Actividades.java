import java.util.Scanner;

public class Actividades {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        /*
        Actividad 1
        Escribamos el código para recibir el tamaño N de un vector (o arreglo) y 
        solicitemos al usuario el valor de cada una de las N posiciones para luego 
        imprimir la suma de todos los valores.
        */
        int t, sum=0;
        System.out.print("Actividad 1\nDigite el tamaño del arreglo: ");
        t = leer.nextInt();
        int A[] = new int[t];
        for (int i = 0; i < A.length; i++){
            System.out.print("Digite el "+(i+1)+" valor del arreglo: ");
            A[i] = leer.nextInt();
            sum = A[i] + sum;
        }
        System.out.println("La sumatoria de los números es: "+sum);
        /*Actividad 2 
        Creemos un programa que llene un vector de N elementos enteros 
        (ingresados por el usuario), imprima la posición y el valor del elemento 
        mayor que se encuentra almacenado en el vector.
        */
        System.out.print("\nActividad 2\nDigite el tamaño del arreglo: ");
        t = leer.nextInt();
        int B[] = new int[t];
        for (int i = 0; i<B.length; i++){
            B[i] = (int)(Math.random()*100);
            System.out.println(B[i]);
        }
        int pos = 1, mayor = B[0];

        for (int i = 0;i<B.length;i++) {
            if (mayor < B[i]){
                mayor = B[i];
                pos = i+1;
            }
        }
        System.out.printf("El número mayor es: %d en la posicion del arreglo: %d\n",mayor,pos);

        /*Actividad 3
        Actividad 3.
        Una técnica utilizada en programación está basada en el concepto de Arreglos 
        Paralelos. 
        Estos son arreglos, con información relacionada, es decir, los datos ubicados 
        en una misma posición pero en diferentes arreglos, corresponden a una misma 
        entidad u objeto.

        Leer 4 arreglos A, B, C, D que contienen respectivamente el código, puntaje 
        obtenido en entrevista inicial, puntaje obtenido en prueba psicotécnica y puntaje 
        obtenido en entrevista técnica, para 25 candidatos a la posición de
        de Programador para la Empresa XProg.

        Considerando que todas las pruebas y entrevistas tienen el mismo peso dentro del 
        puntaje total, imprimir: 
        a. Los códigos de aquellos candidatos cuyo puntaje en la prueba técnica superó los 
        75 puntos. 
        b. El código de aquel candidato que obtuvo menor puntaje en la entrevista inicial. 
        En caso de empate, seleccione cualquiera. 
        c. El código del candidato que será contratado (mayor puntaje total). 
        En caso de empate, seleccione cualquiera. 
        d. Un listado en o
        orden ascendente por puntaje total de todos los candidatos.
        */
        int codigo[]            = new int[5];
        int inicial[]           = new int[5];
        int psicotecnica[]      = new int[5];
        int tecnica[]           = new int[5];
        int suma_entrevistas[]  = new int[5];
        System.out.println("\nActividad 3");
        for (int i = 0; i <5; i++){
            codigo[i]       = i+1;
            inicial[i]      = (int)(Math.random()*100); 
            psicotecnica[i] = (int)(Math.random()*100);
            tecnica[i]      = (int)(Math.random()*100);
            suma_entrevistas[i]      = inicial[i] + psicotecnica[i] + tecnica[i];
            System.out.printf("Código: %d | P.inicial: %d | P.psicotecnica: %d | P.tecnica: %d | P.total: %d|\n",codigo[i],inicial[i],psicotecnica[i],tecnica[i],suma_entrevistas[i]);
        }
        System.out.println("\nCandidatos que superaron los 75 puntos en la prueba tecnica:");
        int menor = inicial[0], cmenor = 1, cmayor = 1;
        boolean alguien = false;
        mayor = suma_entrevistas[0];

        for (int i = 0; i < 5; i++) {
            if (tecnica[i] > 75 ) {
                System.out.println(codigo[i]);
                alguien = true;
            }

            if (menor > inicial[i]){
                menor = inicial[i];
                cmenor = i+1;
            }

            if (mayor < suma_entrevistas[i]){
                mayor = suma_entrevistas[i];
                cmayor = i+1;
            }
        }
        
        if (alguien == false){
            System.out.println("Nadie supero los 75 puntos en la prueba tecnica");
        }

        System.out.println("\nEl código de candidato que obtuvo menor puntaje en la entrevista inicial fue: "+ cmenor);
        System.out.println("\nEl código de candidato que será contratado: "+ cmayor);
        int temp, temp_1;
        for (int i = 0; i<5; i++) {
            for (int j = i+1; j < 5; j++){
                if (suma_entrevistas[i] > suma_entrevistas[j]){
                    temp = suma_entrevistas[i];
                    temp_1 = codigo[i];

                    suma_entrevistas[i] = suma_entrevistas[j];
                    codigo[i] = codigo[j];

                    suma_entrevistas[j] = temp;
                    codigo[j] = temp_1;
                }
            }
        }
        System.out.println("\nPuntaje de sumatoria total ordenado:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Puntaje total: "+suma_entrevistas[i]+" | Código: "+codigo[i]);
        }
        leer.close();
    }  
}
