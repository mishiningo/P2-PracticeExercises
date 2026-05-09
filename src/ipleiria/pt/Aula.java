package ipleiria.pt;

import java.util.LinkedList;

public class Aula {

    //Atributos
    private String nome;
    private long numero;
    private String sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;

    //Construtores
    public Aula(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos) {
            adicionarAluno(aluno);
        }
        this.sumario = "";
    }

    //Métodos
    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public LinkedList<Aluno> getAlunos() {
        return alunos;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void adicionarAluno(Aluno aluno) {
        if(this.alunos == null) {
            System.out.println("Lazy Initialization");
            this.alunos = new LinkedList<>();
        }
        if(this.alunos.contains(aluno)) {
            System.out.println("Aluno já existente");
            return;
        }
        if (aluno == null) {
            System.out.println("Aluno null");
            return;
        }
        this.alunos.add(aluno);
    }

    public void adicionarProfessor(Professor professor) {
        if(professor == null) {
            System.out.println("Professor null");
            return;
        }
        this.professor = professor;
    }
}
