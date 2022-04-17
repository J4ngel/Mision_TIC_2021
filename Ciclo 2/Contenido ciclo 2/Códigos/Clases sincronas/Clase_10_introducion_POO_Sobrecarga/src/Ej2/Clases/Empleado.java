package Ej2.Clases;

public class Empleado extends Persona {
    private String codigo, banco;
    private int nroCuenta, mesFacturacion;

    

    public Empleado(String codigo, String banco, int nroCuenta, int mesFacturacion, 
                     String nombre, String apellido, String celular, int id) {
        super(nombre, apellido, celular, id); //Super invoca al constructor de la/s superclase/s
        this.codigo = codigo;
        this.banco = banco;
        this.nroCuenta = nroCuenta;
        this.mesFacturacion = mesFacturacion;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }
    public int getNroCuenta() {
        return nroCuenta;
    }
    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
    public int getMesFacturacion() {
        return mesFacturacion;
    }
    public void setMesFacturacion(int mesFacturacion) {
        this.mesFacturacion = mesFacturacion;
    }
}
