package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    @Test void notificaTodosOsInscritos() {
        Turma turma = new Turma("Arquitetura de Software", "A");
        Aluno ana = new Aluno("Ana");
        Aluno bia = new Aluno("Bia");
        ana.matricular(turma); bia.matricular(turma);
        turma.publicarAviso("Notas publicadas");
        assertEquals("Ana: Notas publicadas em Arquitetura de Software (A)", ana.getUltimaNotificacao());
        assertEquals("Bia: Notas publicadas em Arquitetura de Software (A)", bia.getUltimaNotificacao());
    }
    @Test void naoNotificaOutrasTurmasNemExInscritos() {
        Turma a = new Turma("Arquitetura de Software", "A");
        Turma b = new Turma("Arquitetura de Software", "B");
        Aluno ana = new Aluno("Ana"); Aluno bia = new Aluno("Bia");
        ana.matricular(a); bia.matricular(b);
        a.publicarAviso("Notas publicadas");
        assertNull(bia.getUltimaNotificacao());
        a.cancelarInscricao(ana);
        a.publicarAviso("Novo aviso");
        assertEquals("Ana: Notas publicadas em Arquitetura de Software (A)", ana.getUltimaNotificacao());
    }
}
