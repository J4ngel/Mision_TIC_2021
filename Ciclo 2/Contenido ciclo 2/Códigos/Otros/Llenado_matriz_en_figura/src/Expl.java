public class Expl {
    public static void main(String[] args) {
        /* char letras1[][] = new char[3][3];
        String letras2[][] = new String[3][3];
        char letras3[][] = {{'A','B','C'},{'D','E','F'},{'G','H','I'}}; 
        String letras4[][] = {{"'A'","'B'","'C'"},{"'D'","'E'","'F'"},{"'G'","'H'","'I'"}};
        char dato = ' '; 
        System.out.println("Matriz vacia, tipo de dato char:");
        for(int filas = 0; filas < 3; filas++){
            System.out.print("|");
            for(int columnas=0; columnas < 3; columnas++){
                if(filas == 0){dato = 'A';}
                else if(filas == 1){dato = 'B';}
                else if(filas == 2){dato = 'C';}
                letras1[filas][columnas] = dato;
                System.out.print(" "+letras1[filas][columnas]+" |");
            }
            System.out.println();
        }
        System.out.println("Matriz vacia, tipo de dato String:");
        for(int filas = 0; filas < letras2.length; filas++){
            System.out.print("|");
            for(int columnas=0; columnas < letras2[filas].length; columnas++){
                letras2[filas][columnas] = "Z";
                System.out.print(" "+letras2[filas][columnas]+" |");
            }
            System.out.println();
        }
        //----------------------------------------------------------------
        System.out.println("Matriz pre definida, tipo de dato char:");
        for(int filas = 0; filas < 3; filas++){
            System.out.print("|");
            for(int columnas=0; columnas < 3; columnas++){
                System.out.print(" "+letras3[filas][columnas]+" |");
            }
            System.out.println();
        }
        System.out.println("Matriz pre definida, tipo de dato String:");
        for(int filas = 0; filas < letras4.length; filas++){
            System.out.print("|");
            for(int columnas=0; columnas < letras4[filas].length; columnas++){
                System.out.print(" "+letras4[filas][columnas]+" |");
            }
            System.out.println();
        }
        System.out.println("La letra que hay en la fila 2 columna 2 es: "+letras4[1][1]); */

        int matriz[][] = new int[5][4];

        for (int i = 0; i <5;i++){
            for (int j = 0; j <4;j++){
                if(i > 2 & j < 3){ matriz[i][j]=2;}
                System.out.print(" "+matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}
