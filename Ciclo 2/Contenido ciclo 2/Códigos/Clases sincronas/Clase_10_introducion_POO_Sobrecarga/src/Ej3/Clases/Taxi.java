package Ej3.Clases;

public class Taxi extends Vehiculo{
    private boolean aa;

    public Taxi(boolean aa) { //Constructor 1
        super();
        this.aa = aa;
    }

    public Taxi(String matricula, boolean aa) { //Constructor 2
        super(matricula);
        this.aa = aa;
    }

    public Taxi(String matricula, int sillas, boolean aa) { //Constructor 3
        super(matricula, sillas);
        this.aa = aa;
    }

    public boolean isaa() {
        return aa;
    }

    public void setaa(boolean aa) {
        this.aa = aa;
    }
}
