package ipleiria.pt;

import java.util.LinkedList;

public class Seguranca extends Identificador implements Funcionario<GabineteSeguranca, Divisao>{
    private GestorFuncionarios<GabineteSeguranca, Divisao> gestorFuncionarios;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {
        super(nome,numero);
        gestorFuncionarios = new GestorFuncionarios<>(this, gabinete);
    }

    @Override
    public GabineteSeguranca getGabinete() {
        return gestorFuncionarios.getGabinete();
    }

    @Override
    public LinkedList<Horario> getHorariosAtendimento() {
        return gestorFuncionarios.getHorariosAtendimento();
    }

    @Override
    public void abrir(Divisao divisao){
        gestorFuncionarios.abrir(divisao);
    }

    @Override
    public void abrirGabinete(){
        gestorFuncionarios.abrirGabinete();
    }

    @Override
    public void fechar(Divisao divisao){
        gestorFuncionarios.fechar(divisao);
    }

    @Override
    public void fecharGabinete(){
        gestorFuncionarios.fecharGabinete();
    }

    @Override
    public void setGabinete(GabineteSeguranca gabinete) {
        gestorFuncionarios.setGabinete(gabinete);
    }

    @Override
    public void removeGabinete(){
        gestorFuncionarios.removeGabinete();
    }

    @Override
    public void adicionar(Horario horarioAtendimento) {
        gestorFuncionarios.adicionar(horarioAtendimento);
    }

    @Override
    public void remover(Horario horarioAtendimento) {
        gestorFuncionarios.remover(horarioAtendimento);
    }
}
