package ipleiria.pt;

import java.util.LinkedList;

public class Professor extends Identificador {

    //Atributos
    private LinkedList<Aula> aulas;
    private GabineteProfessor gabineteProfessor;
    private LinkedList<Horario> horariosAtendimento;


    //Construtores
    public Professor(String nome, long numero, GabineteProfessor gabineteProfessor) {
        super(nome, numero);
        this.gabineteProfessor = gabineteProfessor;
        gabineteProfessor.adicionarProfessores(this);
        this.aulas = new LinkedList<>();
        horariosAtendimento = new LinkedList<>();
    }

    //Métodos
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

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    //Overload de métodos também é uma cena
    //Metodo pensado para devolver aulas que sobrepõem com a faixa de tempo dada
    //Pelo utilizador, e não pelo tempo exato

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasHorario = new LinkedList<>();
        for(Aula aula : aulas) {
            if(aula.getHorario().isSobreposto(horario)) {
                aulasHorario.add(aula);
            }
        }
        return aulasHorario;
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
