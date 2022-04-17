public class Calzado extends Producto{
    private int Talla;

    public Calzado(){
        super();
        Talla = 0;
    }
    public int getTalla() {
        return Talla;
    }

    public void setTalla(int talla) {
        Talla = talla;
    }
}
