package Ej1.Clases;

import java.util.Scanner;

public class Operaciones {
    protected int val_1, val_2, resultado;
    Scanner sc = new Scanner(System.in);

    public void P_datos(){
        System.out.print("Digite el primer valor: ");
        val_1 = Integer.parseInt(sc.nextLine());
        System.out.print("Digite el segundo valor: ");
        val_2 = Integer.parseInt(sc.nextLine());
    }

    public int mostrar_r(){
        return resultado;
    }
}
