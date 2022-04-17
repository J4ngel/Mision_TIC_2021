package Ej3.main;
import java.util.Scanner;

import Ej3.Clases.*;
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char resp;
        boolean aa;
        String matricula;
        int N_sillas;
        int Sillas_add;

        Vehiculo v1 = new Vehiculo();
        System.out.println("El vehiculo con placa "+v1.getMatricula()+" tiene "+v1.getSillas()+" sillas");

        Vehiculo v2 = new Vehiculo("TXR560");
        System.out.println("El vehiculo con placa "+v2.getMatricula()+" tiene "+v2.getSillas()+" sillas");

        Vehiculo v3 = new Vehiculo("QHE000",5);
        System.out.println("El vehiculo con placa "+v3.getMatricula()+" tiene "+v3.getSillas()+" sillas");

        System.out.print("Tiene aire acondicionado? [s/n]: ");
        resp = sc.next().charAt(0);
        aa = resp == 'S' || resp =='s'; //Operador boleano
        Taxi t1 = new Taxi(aa);
        System.out.printf("El taxi 1 con matricula %s tiene %d sillas y %s%n",t1.getMatricula(),t1.getSillas(),(t1.isaa() ? "tiene aire":"NO tiene aire"));

        sc.close();
    }
}
