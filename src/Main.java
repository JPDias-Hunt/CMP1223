public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", 2020);
        carro.exibirInformacoes();
        carro.acelerar();
        carro.frear();

        System.out.println();

        Moto moto = new Moto("Honda", 2019);
        moto.exibirInformacoes();
        moto.acelerar();
        moto.frear();

        System.out.println();

        SomAutomotivo som = new SomAutomotivo("Pioneer 5000W", 1200.00);
        som.descricao();
        som.instalar();
        som.remover();

        System.out.println();

        GPS gps = new GPS("Garmin XT", 800.00);
        gps.descricao();
        gps.instalar();
        gps.remover();
    }
}
