
public class SchoolGradingSystem extends GradingSystem {
    
    
    public SchoolGradingSystem() {
        super();
    }

    public void loadData(String r, String d){    
        N = Integer.parseInt(r);
        String filas[] = d.split("\n");

        for (int i = 0; i < N; i++) {
            String linea[] = filas[i].split(" ");
                
            int nombre = (int)(Double.parseDouble(linea[0]));
            int materia = (int)(Double.parseDouble(linea[2]));
            
            notas[nombre-1][materia-1] = Double.parseDouble(linea[3]);
        }  
    }
}
