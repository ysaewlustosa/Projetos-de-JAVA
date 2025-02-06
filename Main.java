import java.util.Scanner;

class Conta {

    // Atributos privados
    private String titular;
    private int numeroConta;
    private double saldo;

    // Construtor para inicializar os atributos da conta
    public Conta(String titular, int numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    // Método público para consultar o saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Método público para realizar saque
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    // Método público para realizar depósito
    public void depositar(double valor) {
        saldo += valor;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String titular = sc.nextLine();
        int numeroConta = sc.nextInt();
        double saldoInicial = sc.nextDouble();

        Conta conta = new Conta(titular, numeroConta, saldoInicial);

        // Operações de saque e depósito
        if (sc.hasNextDouble()) {
            double valorSaque = sc.nextDouble();
            if (!conta.sacar(valorSaque)) {
                System.out.println("Saque invalido: Saldo insuficiente");
                System.out.println("Saldo Atual: " + String.format("%.2f", conta.consultarSaldo()));
                return;
            }
        }

        if (sc.hasNextDouble()) {
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
        }

        // Imprime o saldo final atualizado
        System.out.println("Saldo Atualizado: " + String.format("%.2f", conta.consultarSaldo()));

        sc.close(); // Fecha o scanner
    }
}

