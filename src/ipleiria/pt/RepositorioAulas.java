package ipleiria.pt;

import java.util.LinkedList;

public interface RepositorioAulas {
    void associarAula(Aula aula);
    void desassociarAula(Aula aula);
    LinkedList<Aula> getAulas(Horario horario);
    LinkedList<Aula> getAulas();
    void adicionarAula(Aula aula);
    void removerAula(Aula aula);
}
