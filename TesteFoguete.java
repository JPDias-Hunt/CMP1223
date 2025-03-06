public class TesteFoguete {
    public static void main(String[] args) {


        Foguete foguete1 = new Foguete("Foguete Fraco", 5000, 40000, 100, 5000);
        System.out.println("\n=== Missão 1: Empuxo Insuficiente ===");
        foguete1.lancar();


        Foguete foguete2 = new Foguete("Foguete Sem Combustível", 5000, 150000, 500, 2000);
        System.out.println("\n=== Missão 2: Pouco Combustível ===");
        foguete2.lancar();


        Foguete foguete3 = new Foguete("Foguete Perfeito", 5000, 200000, 300, 20000);
        System.out.println("\n=== Missão 3: Foguete Perfeito ===");
        foguete3.lancar();



        Foguete foguete4 = new Foguete("Foguete Marciano", 5000, 100000, 300, 10000) {
            private double gravidadeMarte = 3.71;

            @Override
            public void lancar() {
                this.gravidade = gravidadeMarte;
                super.lancar();
            }
        };
        System.out.println("\n=== Missão 4: Lançamento em Marte ===");
        foguete4.lancar();
    }
}
