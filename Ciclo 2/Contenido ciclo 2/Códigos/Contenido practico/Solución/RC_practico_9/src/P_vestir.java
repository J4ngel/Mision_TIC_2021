public class P_vestir extends Producto{
    private String Talla;
    private boolean Permite_planchado;
    
    public P_vestir() {
        super();
        Talla = "";
        Permite_planchado =false;
    }

    public String getTalla() {
        return Talla;
    }
    public void setTalla(String talla) {
        Talla = talla;
    }
    public boolean isPermite_planchado() {
        return Permite_planchado;
    }
    public void setPermite_planchado(boolean permite_planchado) {
        Permite_planchado = permite_planchado;
    } 
}
