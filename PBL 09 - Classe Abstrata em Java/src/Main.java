public class Main {
    public static void main(String[] args) {
        Biologo biologo = new Biologo("Ana", "Biologia Marinha");
        Engenheiro engenheiro = new Engenheiro("Lucas", "Engenharia Robótica");
        Medico medico = new Medico("Carla", "Medicina Espacial");

        biologo.relatarStatus();
        biologo.executarTarefa();

        System.out.println();

        engenheiro.relatarStatus();
        engenheiro.executarTarefa();

        System.out.println();

        medico.relatarStatus();
        medico.executarTarefa();
    }
}
