package Repaso;

public class Principal_cajero {
    public static void main(String[] args) {
        Cajero bancolombia = new Deposito();
        Cajero.setSaldo(1000000);
        bancolombia.Operaciones();
    }
}
