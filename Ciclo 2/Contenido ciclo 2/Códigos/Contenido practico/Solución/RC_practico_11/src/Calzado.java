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

    public String mostrar() {
        String mensaje = "| Código: "+Codigo+" | Descripcion: "+Descripcion+" | Precio de compra: $"+P_compra+
        " | Precio de venta: $"+P_venta+" | Cantidad en bodega: "+C_bodega+" | Cantidad min.requerida: "+C_requerida+
        " | Cantidad maxima permitida: "+C_maxima+" | Descuento: "+(100*descuento)+"%" +" | Talla: "+Talla;
        return mensaje;
    }
}
