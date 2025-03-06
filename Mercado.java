import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

class Produto {
    String nome;
    double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + String.format(Locale.US, "%.2f", preco);
    }
}

public class Mercado {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Exibir produtos");
            System.out.println("4. Verificar produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto (ex: 4.50): ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    produtos.add(new Produto(nome, preco));
                    System.out.println("Produto adicionado!");
                    break;
                case 2:
                    System.out.print("Digite o nome do produto a ser removido: ");
                    String remover = scanner.nextLine();
                    boolean removido = produtos.removeIf(p -> p.nome.equalsIgnoreCase(remover));
                    if (removido) {
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 3:
                    System.out.println("\nLista de produtos:");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            System.out.println("- " + p);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do produto para verificar: ");
                    String verificar = scanner.nextLine();
                    boolean encontrado = produtos.stream().anyMatch(p -> p.nome.equalsIgnoreCase(verificar));
                    if (encontrado) {
                        System.out.println("O produto está na lista.");
                    } else {
                        System.out.println("O produto não está na lista.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
