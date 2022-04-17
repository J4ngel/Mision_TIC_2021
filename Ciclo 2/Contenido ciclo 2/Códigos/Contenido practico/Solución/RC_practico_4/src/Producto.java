public class Producto {
    private String Codigo;
    private int Precio_u,C_bodega,C_mrequerida;

    public Producto(String cod, int p, int c1, int c2){
        this.Codigo = cod;
        this.Precio_u = p;
        this.C_bodega = c1;
        this.C_mrequerida = c2;
    }
    public boolean S_pedido(){
        if(C_bodega<C_mrequerida){return true;}
        else{return false;}
    }
    public String getCodigo(){return this.Codigo;}
    public int getPrecio_u(){return this.Precio_u;}
    public int getC_bodega(){return this.C_bodega;}
    public int getC_mrequerida(){return this.C_mrequerida;}
}
