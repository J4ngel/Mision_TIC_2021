import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);

        List<Producto> Lista_p = new ArrayList<Producto>(); //ArrayList es una estructura que permite almacenar obj's
        

        for(int i=0; i<3; i++){
            System.out.printf("Digite el código: ");
            String cod = leer.nextLine();
            System.out.printf("Digite el p/u: $");
            int precio = Integer.parseInt(leer.nextLine());
            System.out.printf("Digite la cantidad en bodega: ");
            int cb = Integer.parseInt(leer.nextLine());
            System.out.printf("Digite la cantidad minima requerida: ");
            int cr = Integer.parseInt(leer.nextLine());
            Producto p = new Producto(cod,precio,cb,cr);
            Lista_p.add(p);
        }

        for (Producto elemen : Lista_p) {
            System.out.println("Codigo producto: "+elemen.getCodigo());
            if (elemen.S_pedido()){System.out.println("Alerta!! debe solicitar pedido al proveedor");}
        }
        
        leer.close();
    }
}
