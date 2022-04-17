package Ej2;

public class Equipo_de_futbol {
    private String Nombre;
    private int Ganados, Perdidos, Empatados, T_puntos;
    public Equipo_de_futbol(){
        Nombre    = "";
        Ganados   = 0;
        Perdidos  = 0;
        Empatados = 0;
        T_puntos  = 0;
    }
    //--------->Metodos especificos
    public int sumarGanados(){
        return 3*Ganados;
    }

    public int sumarEmpatados(){
        return Empatados;
    }

    public int controlPerdidos(){
        return Perdidos;
    }

    public void verEstadisticas(){
        System.out.println("\n"+Nombre);
        System.out.println("Partidos jugados: "+(Ganados+Empatados+Perdidos));
        System.out.println("Partidos ganados: "+Ganados);
        System.out.println("Partidos perdidos: "+Perdidos);
        System.out.println("Partidos empatados: "+Empatados);
        System.out.println("Total de puntos "+ (sumarGanados()+sumarEmpatados()));
    }
    //------------> Getters and Setters
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public int getGanados() {
        return Ganados;
    }
    public void setGanados() {
        Ganados++;
    }
    public int getPerdidos() {
        return Perdidos;
    }
    public void setPerdidos() {
        Perdidos++;
    }
    public int getEmpatados() {
        return Empatados;
    }
    public void setEmpatados() {
        Empatados ++;
    }
    public int getT_puntos() {
        return T_puntos;
    }
    public void setT_puntos(int t_puntos) {
        T_puntos = t_puntos;
    }
    
}
