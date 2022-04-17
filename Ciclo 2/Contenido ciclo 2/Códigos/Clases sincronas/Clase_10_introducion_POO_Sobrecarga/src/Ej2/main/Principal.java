/* Ejercicio 
Durante la sesión de hoy vamos a trabajar herencia con la clase Persona. Define la clase Persona con los atributos: nombre, apellido, identificación, celular. 
Y crea una clase Empleado que extienda Persona, tenga los siguientes atributos adicionales: código interno, banco, número de cuenta, mes a facturar.
Ambas clases deben tener los métodos get y set de todos sus atributos. 

Atributos de la clase Persona: 
nombre - String
apellido - String
identificacion – int
celular – String

Orden de los parámetros de entrada para el constructor de la clase Persona: nombre, apellido,
identificacion, celular 

Atributos adicionales de la clase Empleado:
codigo - String 
banco - String
nroCuenta - int
mesFacturacion - int 

Orden de los parámetros de entrada para el constructor de la clase Empleado: codigo, banco,
nroCuenta, mesFacturacion nombre, apellido, identificacion, celular. */
package Ej2.main;
import Ej2.Clases.*;
public class Principal {
    public static void main(String[] args){
        Empleado e1 = new Empleado("1A","Bancolombia",1234,30,"Daniela","Paez","3016988165",1);
        System.out.println(e1.getNombre()+" "+e1.getApellido()+" cuenta de ahorros "+e1.getBanco()+" #"+e1.getNroCuenta());
    }
}
