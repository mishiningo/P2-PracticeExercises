package ipleiria.pt;

import java.io.Serial;
import java.util.LinkedList;

public class Aluno extends PessoaComAulas {

    //Construtores
    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

    //Métodos

    @Override
    public void associarAula(Aula aula){
        aula.adicionar(this);
    }

    @Override
    public void desassociarAula(Aula aula){
        aula.remover(this);
    }

    public void assinarSumario(StringBuilder sumario){
        sumario.append(this.nome).append("\n");
    }
}
