public class Foguete {

    private String nome;
    private double massa; // kg
    private double empuxo; // Newtons
    private double consumoCombustivel; // kg/s
    private double capacidadeCombustivel; // kg
    private double velocidade = 0; // m/s
    private double altitude = 0; // metros
    protected double gravidade = 9.81; // m/s² (Terra)

    public Foguete(String nome, double massa, double empuxo, double consumoCombustivel, double capacidadeCombustivel) {
        this.nome = nome;
        this.massa = massa;
        this.empuxo = empuxo;
        this.consumoCombustivel = consumoCombustivel;
        this.capacidadeCombustivel = capacidadeCombustivel;
    }

    public void lancar() {
        double tempo = 0;
        double combustivelRestante = capacidadeCombustivel;
        System.out.println("\n🚀 Lançamento do " + nome + "! 🚀");

        while (combustivelRestante > 0) {
            double forcaPeso = (massa + combustivelRestante) * gravidade;
            double forcaLiquida = empuxo - forcaPeso;
            double aceleracao = forcaLiquida / (massa + combustivelRestante);

            if (aceleracao <= 0) {
                System.out.println("❌ O foguete não conseguiu decolar! A força do empuxo é insuficiente.");
                return;
            }

            velocidade += aceleracao;
            altitude += velocidade;
            combustivelRestante -= consumoCombustivel;
            tempo++;

            System.out.printf("⏱️ Tempo: %d s | 🛢️ Combustível: %.2f kg | 🚀 Altitude: %.2f m | 🔥 Velocidade: %.2f m/s%n",
                    (int) tempo, combustivelRestante, altitude, velocidade);
        }

        System.out.println("\n💥 O combustível acabou!");
        if (altitude >= 100000) {
            System.out.println("🌍 O foguete atingiu a órbita terrestre com sucesso! 🚀🎉");
        } else {
            System.out.println("❌ O foguete não atingiu a órbita. Altitude final: " + altitude + " m");
        }
    }
}

