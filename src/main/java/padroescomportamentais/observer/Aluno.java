package padroescomportamentais.observer;

public class Aluno implements Observador {
    private final String nome;
    private String ultimaNotificacao;

    public Aluno(String nome) { this.nome = nome; }
    public void matricular(Turma turma) { turma.inscrever(this); }
    public void atualizar(Turma turma, String aviso) {
        ultimaNotificacao = nome + ": " + aviso + " em " + turma.getDisciplina() + " (" + turma.getIdentificador() + ")";
    }
    public String getUltimaNotificacao() { return ultimaNotificacao; }
}
