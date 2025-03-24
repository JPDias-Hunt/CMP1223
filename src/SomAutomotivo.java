// ClasseC: SomAutomotivo (herda Acessorio, implementa Equipavel)
public class SomAutomotivo extends Acessorio implements Equipavel {
    public SomAutomotivo(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public void instalar() {
        System.out.println("Som automotivo instalado.");
    }

    @Override
    public void remover() {
        System.out.println("Som automotivo removido.");
    }
}
