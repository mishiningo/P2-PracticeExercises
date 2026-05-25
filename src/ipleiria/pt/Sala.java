package ipleiria.pt;

import java.util.LinkedList;

public class Sala extends Divisao {
    //Atributos
    private LinkedList<Aula> aulas;

    public Sala(String nome, boolean aberta) {
        super(nome, aberta);
        aulas = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean isAberta() {
        return aberta;
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasHorario = new LinkedList<>();
        for(Aula aula : aulas) {
            if(aula.getHorario().isSobreposto(horario) && horario != null) {
                aulasHorario.add(aula);
            }
        }
        return aulasHorario;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public void adicionarAula(Aula aula) {
        if(aulas == null) {
            return;
        }
        if(aulas.contains(aula)) {
            System.out.println("Aula já existente");
            return;
        }
        this.aulas.add(aula);
        //aula.adicionar(this);
        // Recursividade: Se remover a aula da sala tambem tenho de remover a sala da aula
        //Todo
    }

    public void removerAula(Aula aula) {
        if(aulas == null) {
            return;
        }
        if(!aulas.contains(aula)) {
            System.out.println("Aula inexistente");
            return;
        }
        this.aulas.remove(aula);
        //aula.remover(this);
        //Todo
    }
}
