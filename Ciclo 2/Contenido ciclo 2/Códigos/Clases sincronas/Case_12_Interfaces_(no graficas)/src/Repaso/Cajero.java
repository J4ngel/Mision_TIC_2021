package Repaso;

import java.util.Scanner;

public abstract class Cajero {
    protected int retiro, deposito;
    private static int saldo;
    Scanner sc = new Scanner(System.in);

    public void Operaciones(){
        boolean salir = false;
        while(!salir){
            System.out.println("------>Menú cajero");
            System.out.println("1> Consulta");
            System.out.println("2> Retiro");
            System.out.println("3> Deposito");
            System.out.println("4> Salir");
            System.out.print("Digite una opsción del menú: ");
            String opcion = sc.nextLine();
            System.out.println();

            switch (opcion) {
                case "1": //Consulta
                    Cajero con = new Consulta();
                    con.transacciones();
                    System.out.println();
                    break;
                
                case "2": //Retiro
                    Cajero ret = new Retiro();
                    ret.transacciones();
                    System.out.println();
                    break;

                case "3": //Deposito
                    Cajero dep = new Deposito();
                    dep.transacciones();
                    System.out.println();
                    break;

                case "4": //Salir
                    salir = true;
                    System.out.println("Gracias por usar nuestro software!!");
                    break;

                default:
                    System.out.println("Error entrada no valida!!");
                    break;
            }
        }
    }
    //Metodo abstracto
    public abstract void transacciones();
    //Metodo para solicitar catidad de retiro
    public void retiro(){
        retiro = Integer.parseInt(sc.nextLine());
    }
    //Metodo para solicitar la cantidad a depositar
    public void deposito(){
        deposito = Integer.parseInt(sc.nextLine());
    }

    public static int getSaldo() {
        return saldo;
    }
    public static void setSaldo(int saldo) {
        Cajero.saldo = saldo;
    }
}
