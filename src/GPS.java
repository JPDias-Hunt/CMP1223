// ClasseD: GPS (herda Acessorio, implementa Equipavel)
public class GPS extends Acessorio implements Equipavel {
    public GPS(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public void instalar() {
        System.out.println("GPS instalado.");
    }

    @Override
    public void remover() {
        System.out.println("GPS removido.");
    }
}
