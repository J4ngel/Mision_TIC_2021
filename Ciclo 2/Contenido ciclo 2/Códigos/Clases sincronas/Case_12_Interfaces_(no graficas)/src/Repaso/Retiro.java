package Repaso;

public class Retiro extends Cajero{
    
    public void transacciones(){
        System.out.print("Cantidad a retirar: ");
        retiro();
        if(retiro <= getSaldo()){
            setSaldo(getSaldo() - retiro);
            System.out.println("Retiraste: "+retiro);
            System.out.println("Tu nuevo saldo es: "+ getSaldo());
        }else{System.out.println("Saldo insuficiente!!");}
    }
}
