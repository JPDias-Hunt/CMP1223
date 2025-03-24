// Classe1: Veiculo
public class Veiculo {
    String marca;
    int ano;

    public Veiculo(String marca, int ano) {
        this.marca = marca;
        this.ano = ano;
    }

    public void exibirInformacoes() {
        System.out.println("Marca: " + marca + ", Ano: " + ano);
    }
}

