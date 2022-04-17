public class GradingSystem {
    //---------->Atributos
    protected final String Nombres[] = {"armando","nicolas","daniel","maria","marcela","alexandra"};
    protected final String Materias[] = {"geografia","matematicas","informatica"};
    protected double Notas[][];
    //----------->Metodos especificos
    public double stat1(){
        double prom = 0;
        for (double[] estudiante : Notas) {
            for (double nota : estudiante) {
                if(nota > 2.5 && nota<=5){prom++;}
            }
        }
        return prom/(Nombres.length*Materias.length);
    }

    public int stat2(){
        int insuficientes = 0; 
        for (double[] estudiante : Notas) {
            for (double nota : estudiante) {
                if(nota > 1 && nota<=2.5){insuficientes++;}
            }
        }
    return insuficientes;
    }
    public String stat3(){
        double menor_p = 6;
        int materia = 0;

        for (int i = 0; i < 3; i++) {
            double prom = 0;
            for (int j = 0; j < 3; j++) {
                    prom += Notas[j][i];
            }
            prom /= 3;
            if(menor_p > prom){
                menor_p = prom;
                materia = i;
            }
        }
        return Materias[materia];
    }
    public String stat4(){
        int estudiante = 0;
        double mayor = Notas[0][0];

        for(int i=0; i < 6; i++){
            if(mayor < Notas[i][0]){
                estudiante = i;
                mayor = Notas[i][0];
            }
        }
        return Nombres[estudiante];
    }
}
