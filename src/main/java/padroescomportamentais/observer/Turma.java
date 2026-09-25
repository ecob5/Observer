package padroescomportamentais.observer;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private final String disciplina;
    private final String identificador;
    private final List<Observador> alunos = new ArrayList<>();

    public Turma(String disciplina, String identificador) {
        this.disciplina = disciplina;
        this.identificador = identificador;
    }
    public void inscrever(Observador aluno) {
        if (aluno == null) throw new IllegalArgumentException("Observador obrigatório");
        if (!alunos.contains(aluno)) alunos.add(aluno);
    }
    public void cancelarInscricao(Observador aluno) { alunos.remove(aluno); }
    public void publicarAviso(String aviso) {
        for (Observador aluno : new ArrayList<>(alunos)) aluno.atualizar(this, aviso);
    }
    public String getDisciplina() { return disciplina; }
    public String getIdentificador() { return identificador; }
}
