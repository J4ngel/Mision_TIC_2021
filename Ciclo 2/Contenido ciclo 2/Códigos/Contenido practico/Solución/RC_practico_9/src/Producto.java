public class Producto {
    private String Codigo, Descripcion;
    private int P_compra, P_venta, C_bodega, C_requerida, C_maxima;
    private static double descuento = 0.01;
    
    //Constructor
    public Producto() {
        this.Codigo = this.Descripcion="";
        this.P_compra = this.P_venta = this.C_bodega = this.C_requerida = this.C_maxima = 0;
    }
    //Metodos especificos
    public boolean S_pedido(){return (C_bodega < C_requerida);}

    public double T_pagar(int cantidad){return ((P_compra*cantidad)-(P_compra*cantidad*descuento));}
    // Getters and Setters
    public String getCodigo() {
        return Codigo;
    }
    public void setCodigo(String codigo) {
        Codigo = codigo;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    public int getP_compra() {
        return P_compra;
    }
    public void setP_compra(int p_compra) {
        P_compra = p_compra;
    }
    public int getP_venta() {
        return P_venta;
    }
    public void setP_venta(int p_venta) {
        P_venta = p_venta;
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
    public int getC_maxima() {
        return C_maxima;
    }
    public void setC_maxima(int c_maxima) {
        C_maxima = c_maxima;
    }
    public static double getDescuento() {
        return descuento;
    }
    public static void setDescuento(double descuento) {
        Producto.descuento = descuento;
    }
    
}
