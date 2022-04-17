package Clases;

import java.util.ArrayList;

import Main.Principal;

public class Partida {
    private Adulto usuario_a;
    private Nino usuario_b;
    private ArrayList <Tablero> Cartones = new ArrayList<Tablero>();
    private int memoria[][] = new int[15][5];
    private int mem_columna[] = new int[5];
    
    //------>Constructores
    public Partida(Adulto usuario_a) {
        this.usuario_a = usuario_a;
        this.usuario_b = null;
    }
    public Partida(Nino usuario_b) {
        this.usuario_b = usuario_b;
        usuario_a = null;
    }
     
    //-------------->METODOS ESPECIFICOS<------------
    //---->Metodo sobrecargado jugar para MAYORES de edad
    public void jugar(int n_tableros, int n_aleatorios){
        usuario_a.setP_jugadas(usuario_a.getP_jugadas()+1);

        for(int i=0; i<n_tableros; i++){
            if(n_aleatorios > 0){
                n_aleatorios--;
                Cartones.add(new Tablero());
                Cartones.get(Cartones.size()-1).T_aleatorio();
            }else{
                System.out.printf("\nLlenado de datos carton #%d:\n", (i+1));
                Cartones.add(new Tablero());
                Cartones.get(Cartones.size()-1).T_personalizado();
            }
        }

        boolean salir = false, error = false;
        //String ya_salieron ="";  //Variable de verificación balotas que ya salieron
        while(!todos_los_numeros()){
            error = false;
            imprimir_tableros();
            //System.out.println(ya_salieron);       //Verificación de las valotas que ya salieron
            String balota[] = balota();
            //ya_salieron += Tablero.getLetras()[Integer.parseInt(balota[0])]+balota[1]+" "; //Agregue la balota recien salida
            System.out.println("| > s: Salir  | > 0: Siguiente balota  |");
            System.out.print("Digite los tableros que tienen la letra con el valor (separado por comas): ");
            String valores[] = Principal.sc.nextLine().replaceAll(" ","").split(",");
            if(valores.length == 1 && valores[0].equals("0")){
                continue;
            }else if(valores.length == 1 && valores[0].equalsIgnoreCase("s")){
                salir = true;
                break;
            }else{
                for (String carton : valores) {
                    if(Integer.parseInt(carton)<=Cartones.size()){
                        if(!Cartones.get(Integer.parseInt(carton)-1).existe(balota)){
                            System.out.printf("Penalización!!, ese valor no está en el tablero %s, se le descontará una ficha.\n", carton);
                            usuario_a.setFichas(usuario_a.getFichas()-1);
                            error = true;
                        }
                    }else{
                        System.out.printf("El carton %s no existe!!\n", carton);
                        error = true;
                    }
                }
            }
            if(error){Principal.pausa();}
        }

        if(!salir){imprimir_tableros();}
        //System.out.println(ya_salieron);     //Verificación de ejecución correcta
        //System.out.println(ya_salieron.split(" ").length); //Verificación de ejecución correcta (salida esperada 75)
        System.out.println("\n\tGAME OVER");
        Calcular_puntaje();
    }   

    //---->Metodo sobrecargado jugar para MENORES de edad
    public void jugar(int aleatorio){    
        usuario_b.setP_jugadas(usuario_b.getP_jugadas()+1);

        Cartones.add(new Tablero());
        if(aleatorio == 1){Cartones.get(0).T_aleatorio();}
        else{Cartones.get(0).T_personalizado();}
        
        boolean salir = false;
        //String ya_salieron ="";  //Variable de verificación balotas que ya salieron
        while(!todos_los_numeros()){
            imprimir_tableros();
            //System.out.println(ya_salieron);       //Verificación de las valotas que ya salieron
            String balota[] = balota();
            //ya_salieron += Tablero.getLetras()[Integer.parseInt(balota[0])]+balota[1]+" "; //Agregue la balota recien salida
            System.out.println("| > s: Salir  | > 0: Siguiente balota  |");
            System.out.print("Digite 1 si su tablero tiene la letra con el valor: ");
            String valor = Principal.sc.nextLine().replaceAll(" ","");
            System.out.println();

            if(valor.equals("0")){
                continue;
            }else if(valor.equalsIgnoreCase("s")){
                salir = true;
                break;
            }else{
                if(!Cartones.get(0).existe(balota)){
                    System.out.println("Penalización!!, ese valor no está en tu tablero, se te descontará una ficha.");
                    usuario_b.setFichas(usuario_b.getFichas()-1);
                    Principal.pausa();
                }
            }
        }
        if(!salir){imprimir_tableros();}
        //System.out.println(ya_salieron);     //Verificación de ejecución correcta
        //System.out.println(ya_salieron.split(" ").length); //Verificación de ejecución correcta (salida esperada 75)
        System.out.println("\n\tGAME OVER");
        Calcular_puntaje();
    }

    public void imprimir_tableros(){
        for(int C_numero = 0; C_numero < Cartones.size(); C_numero++){
            String temp[][] = Cartones.get(C_numero).getCasillas();
            System.out.printf("\nTablero #: %d\n", (C_numero+1));
            System.out.printf("|");
            for (String letra : Tablero.getLetras()) {System.out.printf(" %-3s|",letra);}
            System.out.println();

            System.out.printf("|");
            for (int i = 0; i<5; i++){System.out.printf("%-4s|","----");}
            System.out.println();

            for(int fila =0; fila<5; fila++){ 
                System.out.printf("|");
                for(int columna = 0; columna<5; columna++){
                    System.out.printf(" %-3s|", temp[fila][columna]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public String[] balota(){
        int columna, indice;
        while(true){
            columna = (int)(Math.random()*(5)+1);
            indice = columna-1;
            if(mem_columna[indice] == 0){
                break;
            }
        }
        //System.out.println("->");  //Seña para saber que salió del primer for
        int num;
        int inferior = (indice*15)+1;
        int superior = (indice*15)+15;

        while(true){
            int n = (int)(Math.random()*(superior-inferior+1)+inferior);
            int indice2 = (n-1)-(15*indice);
            if(memoria[indice2][indice] == 0 && n<=superior && n>=inferior){
                memoria[indice2][indice] = 1;
                num = n;
                break;
            }
        }

        boolean c_llena = true;
        for (int i = 0; i < 15; i++) {
            if(memoria[i][indice]==0){
                c_llena = false;
                break;
            }
        }
        if(c_llena){mem_columna[indice]=1;}

        System.out.printf("\n|   Balota: %s%d   |\n",Tablero.getLetras()[indice], num);
        String balota[] = {indice+"", num+""};
        return balota;
    }

    public boolean todos_los_numeros(){
        for (int columna : mem_columna) {
            if(columna == 0){return false;}
        }
        return true;
    }

    public void Calcular_puntaje(){
       int fichas = 0;    //Variable acumuladora

        for (Tablero carton : Cartones) {  //recorremos cada tablero
            if(f_bingo(carton)){  //bingo
                if(usuario_a != null){fichas += 10000;}  //Si el usuario es mayor de edad
                else{fichas += 5000;}                    //Si el usuario es menor de edad

            }else if(f_O(carton)){  //O
                if(usuario_a != null){fichas += 2000;}
                else{
                    if(usuario_b.getEdad() < 10){fichas += 1000;} //Si el menor de edad tiene menos de 10 años
                    else{fichas += 900;}                          //Si es menor de edad pero al menos tiene 10 años
                }

            }else if(f_U(carton)){  //U
                if(usuario_a != null){fichas += 1500;}           //Solo los adultos reciben fichas por esta figura

            }else if(f_X(carton)){  //X
                if(usuario_a != null){fichas += 1200;}
                else{fichas += 800;}

            }else if(f_C(carton)){  //C  
                if(usuario_a != null){fichas += 1000;}             //Solo los adultos reciben fichas por esta figura

            }else if(f_D(carton)){  //Diagonal
                if(usuario_a != null){fichas += 800;}
                else{fichas += 450;}

            }else if(f_H(carton) || f_V(carton)){  //Linea 
                if(usuario_a != null){fichas += 400;}
                else{fichas += 200;}
            }
        } 

        if(fichas > 0){   // si ganó fichas
            System.out.printf("\n¡¡Felicidades usted ganó %d fichas!!\n", fichas);
            if(usuario_a != null){usuario_a.setFichas(usuario_a.getFichas()+fichas);}
            else{usuario_b.setFichas(usuario_b.getFichas()+fichas);}

        }else{System.out.println("\nNo ganó fichas");}
    }

    public boolean f_bingo(Tablero tablero_a){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!tablero_a.getCasillas()[i][j].equalsIgnoreCase("x")){return false;}
            }
        }
        return true;
    }
    public boolean f_O(Tablero tablero_a){
        for (int i = 0; i < 5; i++) {
            if (   !tablero_a.getCasillas()[i][0].equalsIgnoreCase("x")
                || !tablero_a.getCasillas()[i][4].equalsIgnoreCase("x")
                || !tablero_a.getCasillas()[0][i].equalsIgnoreCase("x")
                || !tablero_a.getCasillas()[4][i].equalsIgnoreCase("x")){
                    return false;
                }
        }
        return true;
    }
    public boolean f_U(Tablero tablero_a){
        for (int i = 0; i < 5; i++) {
            if (   !tablero_a.getCasillas()[i][0].equalsIgnoreCase("x")
                || !tablero_a.getCasillas()[i][4].equalsIgnoreCase("x")
                || !tablero_a.getCasillas()[4][i].equalsIgnoreCase("x")){
                    return false;
                }
        }
        return true;
    }
    public boolean f_X(Tablero tablero_a){
        int k = 4;
        for (int i = 0; i < 5; i++) {
            if(!tablero_a.getCasillas()[i][i].equalsIgnoreCase("x")
                || !tablero_a.getCasillas()[i][k].equalsIgnoreCase("x")){return false;}
            k--;
        }
        return true;
    }
    public boolean f_C(Tablero tablero_a){
        for (int i = 0; i < 5; i++) {
            if (   !tablero_a.getCasillas()[i][0].equalsIgnoreCase("x")
                || !tablero_a.getCasillas()[0][i].equalsIgnoreCase("x")
                || !tablero_a.getCasillas()[4][i].equalsIgnoreCase("x")){
                    return false;
                }
        }
        return true;
    }
    public boolean f_D(Tablero tablero_a){
        boolean der = true, izq = true;
        int k = 4;
        for (int i = 0; i < 5; i++) {
            if(!tablero_a.getCasillas()[i][i].equalsIgnoreCase("x")){izq = false;}
            if(!tablero_a.getCasillas()[i][k].equalsIgnoreCase("x")){der = false;}
            k--;
        }
        return der || izq;
    }
    public boolean f_H(Tablero tablero_a){
        int lineas = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!tablero_a.getCasillas()[i][j].equalsIgnoreCase("x")){
                    lineas--;
                    break;
                }
            }
        }
        return lineas > 0;
    }
    public boolean f_V(Tablero tablero_a){
        int lineas = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!tablero_a.getCasillas()[j][i].equalsIgnoreCase("x")){
                    lineas--;
                    break;
                }
            }
        }
        return lineas > 0;
    }
}
