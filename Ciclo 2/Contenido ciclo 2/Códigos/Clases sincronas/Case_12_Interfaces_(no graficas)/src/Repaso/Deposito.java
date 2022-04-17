package Repaso;

public class Deposito extends Cajero{
    
    public void transacciones(){
        System.out.println("Valor de tu deposito:");
        deposito();
        setSaldo(getSaldo()+deposito);
        System.out.println("Depositaste: "+deposito);
        System.out.println("Tu nuevo saldo es:"+ getSaldo());
    }
}
