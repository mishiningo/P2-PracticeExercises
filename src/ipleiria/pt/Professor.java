package ipleiria.pt;

import java.util.LinkedList;

public class Professor extends PessoaComAulas{
    //Atributos
    private GabineteProfessor gabineteProfessor;
    private LinkedList<Horario> horariosAtendimento;


    //Construtores
    public Professor(String nome, long numero, GabineteProfessor gabineteProfessor) {
        super(nome, numero);
        this.gabineteProfessor = gabineteProfessor;
        gabineteProfessor.adicionarProfessores(this);
        horariosAtendimento = new LinkedList<>();
    }

    //Métodos

    @Override
    public void associarAula(Aula aula){
        this.aulas.add(aula);
    }

    @Override
    public void desassociarAula(Aula aula) {
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

    public GabineteProfessor getGabinete() {
        return gabineteProfessor;
    }

    public LinkedList<Horario> getHorariosAtendimento() {
        return horariosAtendimento;
    }

    public void abrir(Sala sala){
        if(sala == null){
            return;
        }
        if(sala.isAberta()){
            System.out.println("Sala já aberta!");
        }
        sala.setAberta(true);
    }

    public void abrirGabinete(){
        if(this.gabineteProfessor.isAberta()){
            System.out.println("Gabinete já aberto!");
        }
        this.gabineteProfessor.setAberta(true);
    }

    public void fechar(Sala sala){
        if(sala == null){
            return;
        }
        if(!sala.isAberta()){
            System.out.println("Sala já fechada!");
        }
        sala.setAberta(false);
    }

    public void fecharGabinete(){
        if(!this.gabineteProfessor.isAberta()){
            System.out.println("Gabinete já fechado!");
        }
        this.gabineteProfessor.setAberta(false);
    }

    public void setGabineteProfessor(GabineteProfessor gabineteProfessor) {
        this.gabineteProfessor = gabineteProfessor;
    }

    public void adicionar(Horario horarioAtendimento) {
        if (horarioAtendimento == null){
            return;
        }
        this.horariosAtendimento.add(horarioAtendimento);
    }

}
