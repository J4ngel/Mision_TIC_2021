package Ej2;

public class Libro {
    private String Titulo, Autor, Tematica, Resumen;
    private int numEjemplares;

    //------->Constructor
    public Libro(){
        this.Titulo = this.Autor = this.Tematica = this.Resumen = "";
        this.numEjemplares = 0;
    }

    
    public Libro(String titulo, String autor, String tematica, String resumen, int numEjemplares) {
        this.Titulo = titulo;
        this.Autor = autor;
        this.Tematica = tematica;
        this.Resumen = resumen;
        this.numEjemplares = numEjemplares;
    }
    //------->Metodos especificos
    public int Adquisiciones(int N_adq){
        numEjemplares += N_adq;
        return numEjemplares;
    }

    public String Prestamo(){
        String mensaje = "Error. No hay existencias del libro!!";
        if(numEjemplares > 0){
            numEjemplares--;
            mensaje = "Préstamo realizado a satisfacción";
        }
        return mensaje;
    }

    public String Devoluciones(){
        numEjemplares++;
        return "Devolución realizado a satisfacción";
    }
    //------->Getters and Setters
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getTematica() {
        return Tematica;
    }

    public void setTematica(String tematica) {
        Tematica = tematica;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String resumen) {
        Resumen = resumen;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    
}
