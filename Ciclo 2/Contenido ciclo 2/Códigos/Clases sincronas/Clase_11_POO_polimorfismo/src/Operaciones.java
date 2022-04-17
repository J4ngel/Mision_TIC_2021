import java.util.Scanner;

/*Capacidad de un objeto para responder de difernetes formas 
-La clase debe se abstacta (modificador abstract)
-Lo mismo para el metodo que va a ser polimorfico ()*/
public abstract class Operaciones {
    protected int val_1, val_2, resultado;

    Scanner sc = new Scanner(System.in);

    public void p_datos(){
        System.out.print("Digite valor uno: ");
        val_1 = Integer.parseInt(sc.nextLine());
        System.out.print("Digite valor dos: ");
        val_2 = Integer.parseInt(sc.nextLine());
    }
    public abstract void operacion();

    public int m_result(){
        return resultado;
    }
}
