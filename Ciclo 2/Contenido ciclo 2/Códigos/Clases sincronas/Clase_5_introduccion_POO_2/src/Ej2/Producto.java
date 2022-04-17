package Ej2;
public class Producto {
    public String Cod;
    public int p_u,c_b,c_r;

    public boolean S_pedido(){
        if (c_b < c_r){return true;}
        else{return false;}
    }
}
