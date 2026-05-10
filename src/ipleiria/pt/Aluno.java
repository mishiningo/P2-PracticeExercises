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
        //Linha 88 da class Aula
        //aula.adicionar(this);
    }

    public void remover(Aula aula){
        if(aula==null || !this.aulas.contains(aula)){
            System.out.println("Aula nula ou aula ja removida");
            return;
        }
        this.aulas.remove(aula);
        //Ler linha 88 da class Aula
        //aula.remover(this);
    }

   public void assinarSumario(StringBuilder sumario){
        sumario.append(this.nome).append("\n");
    }
}
