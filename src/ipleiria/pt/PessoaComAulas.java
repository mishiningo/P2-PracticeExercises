package ipleiria.pt;

import java.util.LinkedList;

abstract public class PessoaComAulas extends Identificador implements RepositorioAulas{
    protected GestorAulas gestorAulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        this.gestorAulas = new GestorAulas(this);
    }

    @Override
    public LinkedList<Aula> getAulas() {
        return gestorAulas.getAulas();
    }

    @Override
    public LinkedList<Aula> getAulas(Horario horario) {
        return gestorAulas.getAulas();
    }
    @Override
    public void adicionarAula(Aula aula) {
            gestorAulas.adicionar(aula);
        }

    @Override
    public void removerAula(Aula aula){
        gestorAulas.remover(aula);
    }
}
