import java.util.ArrayList;

public class Array_list_uso {
    public static void main(String[] args) {
        ArrayList <Persona> Asistencia = new ArrayList<Persona>();
        Persona p1 = new Persona("Daniela uwu",60062, 22);
        Persona p2 = new Persona("Armando Casas xD",12345, 35);
        Persona p3 = new Persona("Rosa Melano",6789, 50);

        //Adicionar los objertos al array
        Asistencia.add(p1);
        Asistencia.add(p2);
        Asistencia.add(p3);

        //Imprimir el Array de la forma estandar
        /* >) Para hallar el tamaño del arreglo de un objeto ArrayList usar el metodo .size()
        >) Para posicionarse en el objeto con un Array list, usar el metodo get(indice) para que devuelva 
        lo que hay en la posición del argumento */
        
        /* for(int i = 0; i< Asistencia.size(); i++){
            System.out.println(Asistencia.get(i).toString());
            System.out.println(Asistencia.get(i).getNombre()+"\n");
        } */

        //Imprimir el Array como debería ser
        for (Persona persona : Asistencia) {
            System.out.println(persona);
            System.out.println(persona.getNombre()+"\n");
        }

        //Remover un elemento de la lista
        /* Asistencia.remove(1); //En su argumento va el indice del objeto a eliminar
        System.out.println(Asistencia.size()); */

        //Cambiar un elemento del vector
        Asistencia.get(2).setNombre("Jaime");
        System.out.println("----------------");
        for (Persona persona : Asistencia) {
            System.out.println(persona.getNombre());
        }
    }  
}
