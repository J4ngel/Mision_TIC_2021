public class Student {
    private String Nombre;
    private int Genero;
    private double Notas[];

    public Student(int tam) {
        Nombre = "";
        Genero = -1;
        Notas = new double[tam];
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getGenero() {
        return Genero;
    }

    public void setGenero(int genero) {
        Genero = genero;
    }

    public double[] getNotas() {
        return Notas;
    }

    public void setNotas(int materia, double nota) {
        Notas[materia] = nota;
    }
}
