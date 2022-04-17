public class Producto {
    private String Codigo;
    private int P_compra, C_bodega,C_requerida, C_maxima;
    private float Descuento = 0.01f;
    
    public Producto() {
        Codigo = "";
        P_compra = 0;
        C_bodega = 0;
        C_requerida = 0;
        C_maxima = 0;
    }

    public String getCodigo() {
        return Codigo;
    }
    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }
    public int getP_compra() {
        return P_compra;
    }
    public void setP_compra(int p_compra) {
        this.P_compra = p_compra;
    }
    public int getC_bodega() {
        return C_bodega;
    }
    public void setC_bodega(int c_bodega) {
        this.C_bodega = c_bodega;
    }
    public int getC_requerida() {
        return C_requerida;
    }
    public void setC_requerida(int c_requerida) {
        this.C_requerida = c_requerida;
    }
    public int getC_maxima() {
        return C_maxima;
    }
    public void setC_maxima(int c_maxima) {
        this.C_maxima = c_maxima;
    }
    public float getDescuento() {
        return Descuento;
    }
    public void setDescuento(float descuento) {
        this.Descuento = descuento;
    }
    //------>Metodos especificos
    public boolean S_pedido(){
        if(C_bodega < C_requerida){return true;}
        else{return false;}
    }
    public float Total_a_pagar(int unidades){
        return ((unidades*P_compra)-(unidades*P_compra*Descuento));
    }
}
