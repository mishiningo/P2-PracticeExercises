package ipleiria.pt;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor,Sala>{
    //Atributos
    GestorFuncionarios<GabineteProfessor,Sala> gestorFuncionarios;


    //Construtores
    public Professor(String nome, long numero, GabineteProfessor gabineteProfessor) {
        super(nome, numero);
        gestorFuncionarios = new GestorFuncionarios<>(this, gabineteProfessor);
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

    @Override
    public GabineteProfessor getGabinete() {
        return gestorFuncionarios.getGabinete();
    }

    @Override
    public LinkedList<Horario> getHorariosAtendimento() {
        return gestorFuncionarios.getHorariosAtendimento();
    }

    @Override
    public void abrir(Sala sala){
        gestorFuncionarios.abrir(sala);
    }

    @Override
    public void abrirGabinete(){
        gestorFuncionarios.abrirGabinete();
    }

    @Override
    public void fechar(Sala sala){
       gestorFuncionarios.fechar(sala);
    }

    @Override
    public void fecharGabinete(){
        gestorFuncionarios.fecharGabinete();
    }

    @Override
    public void setGabinete(GabineteProfessor gabineteProfessor) {
        gestorFuncionarios.setGabinete(gabineteProfessor);
    }

    @Override
    public void adicionar(Horario horarioAtendimento) {
        gestorFuncionarios.adicionar(horarioAtendimento);
    }

    @Override
    public void removeGabinete() {
        gestorFuncionarios.removeGabinete();
    }

    @Override
    public void remover(Horario horarioAtendimento) {
        gestorFuncionarios.remover(horarioAtendimento);
    }
}
