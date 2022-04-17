import java.util.ArrayList;

public class Grupo {
    private ArrayList <String> Nombres;  
    private ArrayList <String> Materias;
    
    private double Notas[][];
    
    public Grupo() {
        Nombres  = new ArrayList<String>();
        Materias = new ArrayList<String>();
        Notas    = new double[6][3];
    }
    //------------>Get and Set<------------------
    public String getNombres(int indice) {
        /* for (String estudiante : Nombres) {
            System.out.println(">)"+estudiante);
        } */
        return Nombres.get(indice);
    }

    public void setNombres(String nombres) {
        Nombres.add(nombres);
    }

    public ArrayList<String> getMaterias() {
        return Materias;
    }

    public String getMaterias(int indice) {
        return Materias.get(indice);
    }

    public void setMaterias(String materias) {
        Materias.add(materias);
    }

    public double getNotas(int estudiante, int materia) {
        return Notas[estudiante][materia];
    }

    public double[][] getNotas() {
        return Notas;
    }

    public void setNotas(int estudiante, int materia, double nota) {
        Notas[estudiante][materia] = nota;
    }

    
}
