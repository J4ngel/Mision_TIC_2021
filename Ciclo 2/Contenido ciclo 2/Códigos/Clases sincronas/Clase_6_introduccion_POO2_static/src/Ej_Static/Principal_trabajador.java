package Ej_Static;
/* 
El llamado de un atributo/metodo static es: 
nombre_de_la_clase.atributo_estatico
nombre_de_la_clase.metodo_estatico()
*/
public class Principal_trabajador {
    public static void main(String[] args) throws Exception {
        System.out.println("El salario básico es: $"+Trabajador.SalarioBasico);
        
        Trabajador.Aux_transporte = 200000;
        System.out.println("El auxilio de transporte es: $"+Trabajador.Aux_transporte);

        boolean subsidio = Trabajador.derecho_t(10000000);
        System.out.println("Requiere subsidio: "+subsidio);

        /* System.out.println("El iva es: "+Trabajador.getIva()+"%");
        Trabajador t1 = new Trabajador();
        System.out.println("El salario básico en la instancia es: $"+t1.SalarioBasico); */
    }
}
