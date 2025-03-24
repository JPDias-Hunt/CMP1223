// ClasseB: Moto (herda Veiculo, implementa Movimentavel)
public class Moto extends Veiculo implements Movimentavel {
    public Moto(String marca, int ano) {
        super(marca, ano);
    }

    @Override
    public void acelerar() {
        System.out.println("A moto está acelerando.");
    }

    @Override
    public void frear() {
        System.out.println("A moto está freando.");
    }
}
