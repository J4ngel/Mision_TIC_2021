/*Capacidad de un objeto para responder de difernetes formas 
-La clase debe se abstacta (modificador abstract)
-Lo mismo para el metodo que va a ser polimorfico ()*/
public class Principal_operaciones {
    public static void main(String[] args) throws Exception {
        Operaciones sum = new Suma();
        sum.p_datos();
        sum.operacion();
        System.out.printf("El resultado de la suma es: %d\n",sum.resultado);
        
        Resta res = new Resta();
        res.p_datos();
        res.operacion();
        System.out.printf("El resultado de la resta es: %d\n",res.resultado);
    }
}
