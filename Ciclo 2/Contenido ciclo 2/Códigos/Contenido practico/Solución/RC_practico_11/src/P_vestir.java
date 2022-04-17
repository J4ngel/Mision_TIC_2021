public class P_vestir extends Producto{
    private String Talla;
    private boolean Permite_planchado;
    
    public P_vestir(){
        super();
        Talla = "";
        Permite_planchado = false;
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

    @Override //Comentario de advertencia, no siempre es necesario
    public String mostrar(){
        String mensaje = "| Código: "+Codigo+" | Descripcion: "+Descripcion+" | Precio de compra: $"+P_compra+
        " | Precio de venta: $"+P_venta+" | Cantidad en bodega: "+C_bodega+" | Cantidad min.requerida: "+C_requerida+
        " | Cantidad maxima permitida: "+C_maxima+" | Descuento: "+(100*descuento)+"%" +
        " | Talla: "+Talla+" | Permite planchado: "+(Permite_planchado ? "Si":"No");
        return mensaje;
    }
}
