// Classe2: Acessorio
public class Acessorio {
    String nome;
    double preco;

    public Acessorio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void descricao() {
        System.out.println("Acessório: " + nome + ", Preço: R$" + preco);
    }
}
