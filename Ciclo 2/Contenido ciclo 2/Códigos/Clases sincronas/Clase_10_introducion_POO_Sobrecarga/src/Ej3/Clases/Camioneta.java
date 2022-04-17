package Ej3.Clases;

public class Camioneta extends Vehiculo {
    private int sillas_adicionales;
    private boolean aa;

    

    public Camioneta(String matricula, boolean aa) {
        super(matricula);
        this.aa = aa;
    }

    public int getSillas_adicionales() {
        return sillas_adicionales;
    }

    public int getSillas() {
        int N_sillas_camioneta = super.getSillas()+sillas_adicionales;
        return N_sillas_camioneta;
    }

    public void setSillas_adicionales(int sillas_adicionales) {
        this.sillas_adicionales = sillas_adicionales;
    }

    public boolean isAa() {
        return aa;
    }

    public void setAa(boolean aa) {
        this.aa = aa;
    }
}
