import java.util.Scanner;

public class Act_5 {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        int dia, VC_sin;
        double V_total, iva = 0;
        System.out.print("Digite el día de la semana (1-7): ");
        dia = leer.nextInt();
        System.out.print("Digite el valor de la compra sin iva: $");
        VC_sin = leer.nextInt();
        switch (dia){
            case 1:
                iva = 0.05;
                break;
            case 2:
                iva = 0.03;
                break;
            case 3:
                iva = 0.1;
                break;
            case 4:
                iva = 0.04;
                break;
            case 5:
                iva = 0.06;
                break;
            case 6:
                iva = 0.02;
                break;
            case 7:
                iva = 0.01;
                break;

            default:
                System.out.println("Número de día de la semana no valido!!");
        }
        if (iva != 0){
            iva *= VC_sin;
            V_total = VC_sin - iva;
            System.out.printf("Valor de compra sin iva: $%d. Valor de descuento: $%.2f. Valor a pagar: $%.2f.\n",VC_sin,iva,V_total);
        }
        leer.close();
    }
}
