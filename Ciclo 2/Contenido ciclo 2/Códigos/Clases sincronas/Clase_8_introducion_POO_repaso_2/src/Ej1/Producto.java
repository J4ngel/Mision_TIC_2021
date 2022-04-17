package Ej1;

public class Producto {
    private String Codigo;
    private int P_compra, P_venta, C_bodega, C_requerida, C_maxima;
    private static double descuento = 0.01;

    public Producto(String codigo, int p_compra, int p_venta, int c_bodega, int c_requerida, int c_maxima) {
        Codigo = codigo;
        P_compra = p_compra;
        P_venta = p_venta;
        C_bodega = c_bodega;
        C_requerida = c_requerida;
        C_maxima = c_maxima;
    }

    public boolean S_pedido(){
        if(C_bodega < C_requerida){return true;}
        else{return false;}
    }
    
    public double Total_pagar(int unidades){
        return (unidades*P_compra)-(unidades*P_compra*descuento);
    }

    public int getP_venta() {
        return P_venta;
    }

    public void setP_venta(int p_venta) {
        P_venta = p_venta;
    }

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
        if(c_requerida < 0){c_requerida = 0;}
        C_requerida = c_requerida;
    }

    public int getC_maxima() {
        return C_maxima;
    }

    public void setC_maxima(int c_maxima) {
        C_maxima = c_maxima;
    }
    
}
