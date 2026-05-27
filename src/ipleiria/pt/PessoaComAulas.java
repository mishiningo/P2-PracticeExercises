package ipleiria.pt;

import java.util.LinkedList;

abstract public class PessoaComAulas extends Identificador{
    protected LinkedList<Aula> aulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
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

    public void adicionaAula(Aula aula) {
        if(aula == null) {
            return;
        }
        if(aulas.contains(aula)){
            return;
        }
        associarAula(aula);
    }

    public void removeAula(Aula aula) {
        if(aula == null) {
            return;
        }
        if(!aulas.contains(aula)){
            return;
        }
        desassociarAula(aula);
    }

    abstract void desassociarAula(Aula aula);

    abstract void associarAula(Aula aula);
}
