public class Ej_computador {
    public String Tipo;
    public String Marca;
    public String modelo;
    public String SO;
    public int Ram;
    public int D_duro;
    public int tamano;

    public void mostrar_info(){
        System.out.println("----------------------------------------------");
        System.out.printf("Marca: %s\nTipo: %s\nModelo: %s\nOS: %s\nTamaño: %d\nRam: %d\n",Marca,Tipo,modelo,SO,tamano,Ram);
    }

    public boolean expandir_ram(){
        if (Ram < 8){return true;}
        else{return false;}
    }
}
