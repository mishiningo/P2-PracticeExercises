package ipleiria.pt;

import java.util.LinkedList;

public class GestorFuncionarios<TGabinete extends Gabinete, TDivisao extends Divisao>{
    private LinkedList<Horario> horariosAtendimento;
    private final Funcionario<TGabinete, TDivisao> funcionario;
    private TGabinete gabinete;

    public GestorFuncionarios(Funcionario<TGabinete, TDivisao> funcionario, TGabinete gabinete) {
        this.funcionario = funcionario;
        this.gabinete = gabinete;
        this.horariosAtendimento = new LinkedList<>();
    }

    public TGabinete getGabinete() {
        return gabinete;
    }

    public LinkedList<Horario> getHorariosAtendimento() {
        return horariosAtendimento;
    }

    public void setGabinete(TGabinete gabinete) {
        this.gabinete = gabinete;
        this.gabinete.adicionar(funcionario);
    }

    public void adicionar(Horario horarioAtendimento) {
        if(horarioAtendimento == null){
            return;
        }
        this.horariosAtendimento.add(horarioAtendimento);
    }

    public void remover(Horario horarioAtendimento) {
        if(horarioAtendimento == null){
            return;
        }
        this.horariosAtendimento.remove(horarioAtendimento);
    }

    public void abrirGabinete(){
        if (gabinete == null) {
            return;
        }
        if(gabinete.isAberta()){
            System.out.println("Gabinete já aberto!");
            return;
        }
        this.gabinete.setAberta(true);
    }

    public void fecharGabinete(){
        if (this.gabinete == null) {
            return;
        }
        if(!gabinete.isAberta()){
            System.out.println("Gabinete já fechado!");
            return;
        }
        this.gabinete.setAberta(false);
    }

    public void removeGabinete(){
        this.gabinete = null;
        gabinete.remover(funcionario);
    }

    public void fechar(TDivisao divisao){
        if(divisao == null){
            return;
        }
        if(!divisao.isAberta()){
            System.out.println("Sala já fechada!");
        }
        divisao.setAberta(false);
    }

    public void abrir(TDivisao divisao){
        if(divisao == null){
            return;
        }
        if(divisao.isAberta()){
            System.out.println("Sala já aberta!");
        }
        divisao.setAberta(true);
    }
}
