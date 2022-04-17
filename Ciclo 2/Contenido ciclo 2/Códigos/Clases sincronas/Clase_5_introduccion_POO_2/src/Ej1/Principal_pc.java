package Ej1;
import java.util.Scanner;

public class Principal_pc {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        Ej_computador pc1 = new Ej_computador();
        Ej_computador pc2 = new Ej_computador();
        pc1.Marca = "Acer";
        pc1.Tipo = "Portatil";
        pc1.modelo = "TUF Gaming";
        pc1.setSO("Windows 10");
        pc1.tamano = 14;
        pc1.setRam(8);

        System.out.print("Marca ---> ");
        pc2.Marca = leer.nextLine();
        System.out.print("Tipo ---> ");
        pc2.Tipo = leer.nextLine();
        System.out.print("Modelo ---> ");
        pc2.modelo = leer.nextLine();
        System.out.print("OS ---> ");
        pc2.setSO(leer.nextLine());
        System.out.print("Tamaño ---> ");
        pc2.tamano = Integer.parseInt(leer.nextLine());
        System.out.print("Ram ---> ");
        pc2.setRam(Integer.parseInt(leer.nextLine()));

        System.out.printf("\nMi computador es de marca %s de tipo %s, cuenta con %s como sistema operativo y tiene %d memoria ram\n",pc1.Marca,pc1.Tipo,pc1.getSO(),pc1.getRam());
        if (pc1.expandir_ram()){System.out.println("Debe expandir su memoria Ram");}
        else{System.out.println("Su memoria Ram es la adecuada");}
        System.out.println("------------------------------------------");
        System.out.printf("Mi computador es de marca %s de tipo %s, cuenta con %s como sistema operativo y tiene %d memoria ram\n",pc2.Marca,pc2.Tipo,pc2.getSO(),pc2.getRam());
        if (pc2.expandir_ram()){System.out.println("Debe expandir su memoria Ram");}
        else{System.out.println("Su memoria Ram es la adecuada");}
        
        leer.close();
    }
}