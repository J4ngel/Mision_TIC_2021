import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("\n///////////////////////BIENVENIDO VERIFICADOR DE PALINDROMOS////////////////\n");
        System.out.print("Escriba su oracion o palabra: ");
        String sentence = input.nextLine();
        System.out.print("\nLa oracion o palabra "+sentence);
        sentence = sentence.replaceAll(" ", "");
        String twist ="";
        
        for (int i = 0; i < sentence.length(); i++) {
            twist = sentence.charAt(i)+twist;
        }
        
        if(sentence.equalsIgnoreCase(twist)){
            System.out.println(" es un palindromo");
        }else{
            System.out.println(" NO es un palindromo");
        }
        
        input.close();
    }
}
