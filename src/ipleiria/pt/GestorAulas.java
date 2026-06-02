package ipleiria.pt;

import java.util.LinkedList;

public class GestorAulas {
    LinkedList<Aula> aulas;
    RepositorioAulas repositorioAulas;

    public GestorAulas(RepositorioAulas repositorioAulas) {
        this.repositorioAulas = repositorioAulas;
        this.aulas = new LinkedList<>();
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasHorario = new LinkedList<>();
        for(Aula aula : aulas) {
            if(aula.getHorario().isSobreposto(horario)) {
                aulasHorario.add(aula);
            }
        }
        return aulasHorario;
    }

    public void adicionar(Aula aula){
        if (this.aulas.contains(aula) || aula == null){
            return;
        }
        this.aulas.add(aula);
        repositorioAulas.associarAula(aula);
    }

    public void remover(Aula aula){
        if (!this.aulas.contains(aula) || aula == null){
            return;
        }
        this.aulas.remove(aula);
        repositorioAulas.desassociarAula(aula);
    }
}
