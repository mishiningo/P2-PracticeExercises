package ipleiria.pt;

import java.util.LinkedList;

public class Aula {

    //Atributos
    private String nome;
    private long numero;
    private String sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;

    //Construtores
    public Aula(String nome, long numero, Horario horario,Professor professor, LinkedList<Aluno> alunos) {
        this.nome = nome;
        this.numero = numero;
        this.professor = professor;
        if(this.professor != null) {
            this.professor.adicionaAula(this);
        }
        this.alunos = (alunos!=null) ? alunos : new LinkedList<>();
        for (Aluno aluno : alunos) {
            adicionar(aluno);
        }
        this.sumario = "";
        this.horario = horario;
    }

    //Overload de construtores - this() deve apontar sempre para o contrutor com mais parametros
    public Aula (String nome, long numero) {
        this(nome, numero, null,null, null);
    }

    public Aula (String nome, long numero, Horario horario) {
        this(nome, numero, horario, null, new LinkedList<>());
    }

    //Métodos
    public Horario getHorario() {
        return horario;
    }

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LinkedList<Aluno> getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void adicionar(Aluno aluno) {
        if(this.alunos.contains(aluno)) {
            System.out.println("Aluno ja existente");
            return;
        }
        if (aluno == null) {
            System.out.println("Aluno null");
            return;
        }
        if(this.alunos == null) {
            System.out.println("Lazy Initialization");
            this.alunos = new LinkedList<>();
        }
        this.alunos.add(aluno);
        //Ver remover(Aluno aluno)
        aluno.adicionar(this);
    }

    public void remover(Aluno aluno) {
        if(!this.alunos.contains(aluno)) {
            System.out.println("Aluno não encontrado");
            return;
        }
        if (aluno == null) {
            System.out.println("Aluno null");
            return;
        }
        this.alunos.remove(aluno);
        //Chamada a função para garantir remoção da parte da Aula e do Aluno (Possivelmente não necessária na Ficha 2)
        aluno.remover(this);
    }

    public void setProfessor(Professor professor) {
        if(professor == null) {
            System.out.println("Professor null");
            return;
        }
        this.professor = professor;
        professor.adicionaAula(this);
    }

    public void desassociarProfessor() {
        if(this.professor == null) {
            System.out.println("Professor já não associado");
            return;
        }
        this.professor.removeAula(this);
        this.professor = null;
    }
}
