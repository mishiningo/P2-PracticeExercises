package ipleiria.pt;

import java.io.Serial;
import java.util.LinkedList;

public class Aluno {

    //Atributos
    private String nome;
    private long numero;
    private LinkedList<Aula> aulas;

    //Construtores
    public Aluno(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
        this.aulas = new LinkedList<>();
    }

    //Métodos

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void adicionar(Aula aula){
        if(aula==null || this.aulas.contains(aula)){
            System.out.println("Aula ja existente");
            return;
        }
        if(this.aulas == null){
            this.aulas = new LinkedList<>();
        }
        this.aulas.add(aula);
        //Ver remover(Aluno aluno) em Aula
        aula.adicionar(this);
    }

    public void remover(Aula aula){
        if(aula==null || !this.aulas.contains(aula)){
            System.out.println("Aula nula ou aula ja removida");
            return;
        }
        this.aulas.remove(aula);
        //Ver remover(Aluno aluno) em Aula
        aula.remover(this);
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    //Overload de métodos também é uma cena
    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasHorario = new LinkedList<>();
        for(Aula aula : aulas) {
            if(aula.getHorario().isSobreposto(horario) && horario != null) {
                aulasHorario.add(aula);
            }
        }
        return aulasHorario;
    }

    public void assinarSumario(StringBuilder sumario){
        sumario.append(this.nome).append("\n");
    }
}
