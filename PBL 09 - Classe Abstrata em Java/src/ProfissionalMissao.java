public abstract class ProfissionalMissao {
    protected String nome;
    protected String especialidade;

    public ProfissionalMissao(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public void relatarStatus() {
        System.out.println("Profissional " + nome + " está em operação com especialidade em " + especialidade);
    }

    public abstract void executarTarefa();
}
