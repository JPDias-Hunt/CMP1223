public class Biologo extends ProfissionalMissao {

    public Biologo(String nome, String especialidade) {
        super(nome, especialidade);
    }

    @Override
    public void executarTarefa() {
        System.out.println(nome + " está coletando amostras de organismos marinhos...");
    }
}
