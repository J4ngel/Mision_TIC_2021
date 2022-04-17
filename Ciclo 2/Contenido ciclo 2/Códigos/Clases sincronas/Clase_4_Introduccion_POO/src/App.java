import java.util.Scanner;

/* POO -----> Una nueva forma de programar (P.Orientada.Objetos)
        \->Pilares:
            1) Abstraccion
            2) Encapsulamiento (protejer datos (hay datos publicos y privados))
                    \->  Modificadores de acceso:
                                     publicos | privados | protegidos
                        java --->    public   | private  | protected
                                    
                                    publicos : Todos tienen acceso
                                    privados : Solo a quien yo permita pueden tener acceso
                                    protegidos : Atributo que es mio pero le doy acceso a personas que tienen
                                                 relación conmigo/Quienes se derivan de mi pueden acceder al
                                                 atributo  (se ve mas que todo con la herencia) 
            3) Jerarquia 
            4) Herencia

        \->Fundamentos:
            1)Polimorfismo
   uso ----->Sirve para aproximarnos al mundo real (cosas/objetos que se pueden distinguir) 
   ¿Como lo hago? ----> se define la clase, se le agregan: 
                        >Identificador(nombre de la clase)
                        >Atributos(caracteristicas)
                        >Metodos(Funciones/lo que puede hacer)
                        Por ultimo se instancia(crear un objeto) con un identificador propio

    Clases ----> Algo abstracto se define bien general, mientras mas abstracto mejor*/
public class App {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        Ej_computador pc1 = new Ej_computador();
        Ej_computador pc2 = new Ej_computador();
        pc1.Marca = "Acer";
        pc1.Tipo = "Portatil";
        pc1.modelo = "TUF Gaming";
        pc1.SO = "Windows 10";
        pc1.tamano = 14;
        pc1.Ram = 8;
        
        System.out.print("Marca ---> ");
        pc2.Marca = leer.nextLine();
        System.out.print("Tipo ---> ");
        pc2.Tipo = leer.nextLine();
        System.out.print("Modelo ---> ");
        pc2.modelo = leer.nextLine();
        System.out.print("OS ---> ");
        pc2.SO = leer.nextLine();
        System.out.print("Tamaño ---> ");
        pc2.tamano = Integer.parseInt(leer.nextLine());
        System.out.print("Ram ---> ");
        pc2.Ram = Integer.parseInt(leer.nextLine());

        pc1.mostrar_info();
        pc2.mostrar_info();
        if (pc1.expandir_ram()){
            pc1.Ram += 4;
        }
        if (pc2.expandir_ram()){
            pc2.Ram += 4;
        }
        pc1.mostrar_info();
        pc2.mostrar_info();
        leer.close();
    }
}
