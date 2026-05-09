package ipleiria.pt;

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

    void assinarSumario(StringBuilder sumario){
        sumario.append(this.nome).append("\n");
    }
}
