package Ej_Static;
/*
Variables y metodos estaticos (static):

->No actuan sobre ojetos, se trabaja directamente con la clase
->No acceden a los atributos que no sean estaticos (variables de instancia)
->Para utilizarlos se utliza: nombre_clase.nombre_atributo ó nombre_clase.nombre_metodo()
*/
public class Trabajador {
    private static float iva = 19;                      //Es pivado por ende si o si toca con metodos para usar o saber su valor
    public static final float SalarioBasico = 908526;   //NO se puede cambiar a fuera porque es final (osease constante)
    public static float Aux_transporte = 102853;        //se puede cambiar a fuera
    
    public static boolean derecho_t(float salario){
        return salario<=(2*SalarioBasico);
    }

    public static float getIva() {
        return iva;
    }
    public static void setIva(float iva) {
        Trabajador.iva = iva;
    }
}
