public class Engenheiro extends ProfissionalMissao {

    public Engenheiro(String nome, String especialidade) {
        super(nome, especialidade);
    }

    @Override
    public void executarTarefa() {
        System.out.println(nome + " está ajustando os braços robóticos do submarino...");
    }
}
