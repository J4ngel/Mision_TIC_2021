public class GradingSystem {
    protected String Nombres[] = {"armando","nicolas","daniel","maria","marcela","alexndra"};
    protected String Materias[] = {"geografia","matematicas","informatica"};
    protected double notas[][];
    protected int N;

    public GradingSystem() {
        notas = new double[Nombres.length][Materias.length];
    }

    public double stat1 (){
        return 0.00;
    }
    public int stat2(){
        return 0;
    }
    public String stat3(){
        return "Materia";
    }
    public String stat4(){
        double n_mayor = notas[0][0];
        int indice = 0;
        for (int i = 0; i < notas.length; i++) {
            if(n_mayor < notas[i][0]){
                n_mayor = notas[i][0];
                indice = i;
            }
        }
        return Nombres[indice];
    }
}
