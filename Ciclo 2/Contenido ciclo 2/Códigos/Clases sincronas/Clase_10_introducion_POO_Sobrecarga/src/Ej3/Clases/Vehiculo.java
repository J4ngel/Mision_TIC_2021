package Ej3.Clases;

public class Vehiculo {
    protected String matricula;
    protected int sillas;

    public Vehiculo(){ //Constructor 1
        this.matricula = "CIS142";
        this.sillas = 3;
    } 

    public Vehiculo(String matricula) { //Constructor 2
        this.matricula = matricula;
        this.sillas = 3;
    }

    public Vehiculo(String matricula, int sillas) { //Constructor 3
        this.matricula = matricula;
        this.sillas = sillas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getSillas() {
        return sillas;
    }

    public void setSillas(int sillas) {
        this.sillas = sillas;
    }
}
