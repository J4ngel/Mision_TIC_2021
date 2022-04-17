package Ej1;
public class Ej_computador {
    //----->Atributos
    public String Tipo;
    public String Marca;
    public String modelo;
    private String SO;
    private int Ram;
    private int D_duro;
    public int tamano;
    //-------->Metodos
    //    \->constructor
    //           \->puede tener o no parametros
    public Ej_computador(){
        Marca = "Hp";
        Tipo = "Escritorio";
        SO = "Mac";
        Ram = 16;
    }
    //    \-> metodos get(acceder a una var privada)
    //        son publicos y tiene retorno de valor
    public String getSO(){return SO;}
    public int getRam(){return Ram;}
    public int getD_duro(){return D_duro;}
    //    \-> metodos set(cambiar el valor a una var privada)
    //        son publicos y tienen parametro 1 parametro
    public void setSO(String s){SO = s;}
    public void setRam(int r){Ram = r;}
    public void setD_duro(int d){D_duro = d;}
    //    \-> demas metodos
    public boolean expandir_ram(){
        if (Ram < 8){return true;}
        else{return false;}
    }
}
