public class Medico extends ProfissionalMissao {

    public Medico(String nome, String especialidade) {
        super(nome, especialidade);
    }

    @Override
    public void executarTarefa() {
        System.out.println(nome + " está verificando sinais vitais da tripulação...");
    }
}
