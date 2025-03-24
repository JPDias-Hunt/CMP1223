// ClasseA: Carro (herda Veiculo, implementa Movimentavel)
public class Carro extends Veiculo implements Movimentavel {
    public Carro(String marca, int ano) {
        super(marca, ano);
    }

    @Override
    public void acelerar() {
        System.out.println("O carro está acelerando.");
    }

    @Override
    public void frear() {
        System.out.println("O carro está freando.");
    }
}

