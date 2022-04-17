public class Producto {
    private String Codigo;
    private int P_compra, C_bodega,C_requerida;
    //constructor
    public Producto() {
        Codigo = "";
        P_compra = 0;
        C_bodega = 0;
        C_requerida = 0;
    }
    //Metodo solicitado por el problema
    public boolean S_pedido(){
        if(C_bodega < C_requerida){
            return true;
        }
        else{
            return false;
        }
    }
    //Seccion de getter y setter de cada variable
    public String getCodigo() {
        return Codigo;
    }
    public void setCodigo(String codigo) {
        Codigo = codigo;
    }
    public int getP_compra() {
        return P_compra;
    }
    public void setP_compra(int p_compra) {
        P_compra = p_compra;
    }
    public int getC_bodega() {
        return C_bodega;
    }
    public void setC_bodega(int c_bodega) {
        C_bodega = c_bodega;
    }
    public int getC_requerida() {
        return C_requerida;
    }
    public void setC_requerida(int c_requerida) {
        C_requerida = c_requerida;
    }
}
