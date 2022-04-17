import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner inp = new Scanner(System.in);
        System.out.println("\n//////////////////////////////BIENVENIDO//////////////////////////////");
        System.out.println("Contador de las tres primeras letras en una palabra!");
        System.out.print("Digita tu palabra aqui: ");
        String str = inp.nextLine();
        if (str.length() >= 3) {
            System.out.printf("Las tres primeras letras de %s son '",str);
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
                if(i == 2){
                    System.out.print("'");    
                    break;
                }
            }
        }else{
            System.out.printf("%s no tiene al menos 3 letras",str);
        }
        
        inp.close();
    }
}
