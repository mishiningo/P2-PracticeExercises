package ipleiria.pt;

import java.util.LinkedList;

public class Professor {

    //Atributos
    private String nome;
    private long numero;
    private LinkedList<Aula> aulas;

    //Construtores
    public Professor(String nome, long numero) {
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

    public void adicionaAula(Aula aula) {
        if(aula == null) {
            return;
        }
        if(aulas.contains(aula)){
            System.out.println("O professor já possui a aula!");
            return;
        }
        if (aulas == null){
            System.out.println("Lazy initialization!");
            aulas = new LinkedList<>();
        }
        this.aulas.add(aula);
    }

    public void removeAula(Aula aula) {
        if(aula == null) {
            return;
        }
        if(!aulas.contains(aula)){
            System.out.println("O professor não possui esta aula!");
            return;
        }
        this.aulas.remove(aula);
    }

    public void preencherSumario(Aula aula, String sumario){
        //StringBuilder é mais otimizado para construção de grandes textos
        StringBuilder stringSumario = new StringBuilder();

        //Nome da aula e numero
        stringSumario.append("Aula: ")
                     .append(aula.getNome()).append(" ")
                     .append(aula.getNumero()).append("\n");
        //Nome do professor
        stringSumario.append(this.nome).append("\n");
        //Sumario em si
        stringSumario.append(sumario).append("\n");
        //Assinatura dos alunos com for each
        for(Aluno aluno : aula.getAlunos()){
            aluno.assinarSumario(stringSumario);
        }
        aula.setSumario(stringSumario.toString());
    }
}
