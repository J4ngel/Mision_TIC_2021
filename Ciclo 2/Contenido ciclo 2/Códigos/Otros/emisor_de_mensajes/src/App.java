import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String nombre = "";
        String mensaje = "";
        String salir = "";
        Scanner input = new Scanner(System.in);
        System.out.println("\n///////////Bienvenido al emisor de mensajes//////////////");
        System.out.println("Digita el nombre de la persona a quien le vas a enviar un mensaje, seguido del mensaje\nque le quieras dar, puedes hacer esto las veces que desees, al preguntar si desea\nsalir y respondes con una n o cualquier otra tecla que no sea s volveras a enviar un nuevo mensaje");
        while (true) {
            System.out.print("\nDigita el nombre de la persona: ");
            nombre = input.nextLine();
            System.out.print("Digita el mensaje que le quieres enviar: ");
            mensaje = input.nextLine();
            System.out.println("\nHola "+nombre+", te enviaron el siguiente mensaje: "+mensaje);
            
            System.out.print("\n¿Desea salir (s/n)?: ");
            salir = input.nextLine();
            if(salir.equalsIgnoreCase("s")){
                System.out.println("Gracias por usar nuestro software!!");
                break;
            }else{
                System.out.println("Enviarás otro mensaje :D");
            }
        }
        input.close();
    }
}
