public class SchoolGradingSystem extends GradingSystem {
    //-------->Constructor
    public SchoolGradingSystem(){
        Notas = new double[6][4];
    }
    //-------->Metodo especifico
    public void loadData(String Datos[], int registros){
        for (int i = 0; i < registros; i++) {
            String linea[] = Datos[i].split(" ");
            int estudiante = ((int)(Double.parseDouble(linea[0])) -1);
            int materia    = ((int)(Double.parseDouble(linea[2])) -1);
            Notas[estudiante][materia] = Double.parseDouble(linea[3]);
        }
    }
}
