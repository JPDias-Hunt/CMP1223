import java.util.Scanner;

class BankAccount {
    private final String titular;
    private double saldo;
    private final double taxaJuros;

    public BankAccount(String titular, double saldo, double taxaJuros) {
        this.titular = titular;
        this.saldo = saldo >= 0 ? saldo : 0;
        this.taxaJuros = taxaJuros;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Erro: Saldo não pode ser negativo.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " feito com sucesso.");
        } else {
            System.out.println("Erro: O valor do depósito deve ser positivo.");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && saldo - valor >= 0) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Erro: Saldo insuficiente ou valor inválido.");
        }
    }

    public double calcularSaldoFuturo(int anos) {
        return saldo * Math.pow(1 + (taxaJuros / 100), anos);
    }
}

public class BancoSimulacao {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o nome do titular: ");
            String titular = scanner.nextLine();

            System.out.print("Insira o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            System.out.print("Insira a taxa de juros anual (%): ");
            double taxaJuros = scanner.nextDouble();

            BankAccount conta = new BankAccount(titular, saldoInicial, taxaJuros);

            int opcao;
            do {
                System.out.println("\nMenu Conta Bancária:");
                System.out.println("1 - Depósito 💰");
                System.out.println("2 - Retirar 🏧");
                System.out.println("3 - Ver Saldo Atual 👀");
                System.out.println("4 - Simule o Saldo Futuro 🔮");
                System.out.println("5 - Sair 🚪");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Insira o valor do depósito: ");
                        double deposito = scanner.nextDouble();
                        conta.depositar(deposito);
                    }
                    case 2 -> {
                        System.out.print("Insira o valor do saque: ");
                        double saque = scanner.nextDouble();
                        conta.retirar(saque);
                    }
                    case 3 -> System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    case 4 -> {
                        System.out.print("Insira o número de anos para simulação: ");
                        int anos = scanner.nextInt();
                        double saldoFuturo = conta.calcularSaldoFuturo(anos);
                        System.out.println("O saldo futuro após " + anos + " anos será: R$ " + String.format("%.2f", saldoFuturo));
                    }
                    case 5 -> System.out.println("Obrigado por usar o sistema bancário! 🙏");
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 5);
        }
    }
}
