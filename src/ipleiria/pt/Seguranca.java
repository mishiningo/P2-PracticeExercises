package ipleiria.pt;

import java.util.LinkedList;

public class Seguranca extends Identificador{
    private GabineteSeguranca gabinete;
    private LinkedList<Horario> horariosAtendimento;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {
        super(nome,numero);
        this.gabinete = gabinete;
        gabinete.adicionar(this);
        horariosAtendimento = new LinkedList<>();
    }

    public GabineteSeguranca getGabinete() {
        return gabinete;
    }

    public LinkedList<Horario> getHorariosAtendimento() {
        return horariosAtendimento;
    }

    public void abrir(Divisao divisao){
        if(divisao == null){
            return;
        }
        if(divisao.isAberta()){
            System.out.println("Sala já aberta!");
        }
        divisao.setAberta(true);
    }

    public void abrirGabinete(){
        if(this.gabinete.isAberta()){
            System.out.println("Gabinete já aberto!");
        }
        this.gabinete.setAberta(true);
    }

    public void fechar(Divisao divisao){
        if(divisao == null){
            return;
        }
        if(!divisao.isAberta()){
            System.out.println("Sala já fechada!");
        }
        divisao.setAberta(false);
    }

    public void fecharGabinete(GabineteSeguranca gabineteSeguranca){
        if(!gabineteSeguranca.isAberta()){
            System.out.println("Gabinete já fechado!");
        }
        gabineteSeguranca.setAberta(false);
    }

    public void setGabinete(GabineteSeguranca gabinete) {
        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    public void removeGabinete(){
        this.gabinete = null;
        gabinete.remover(this);
    }

    public void adicionar(Horario horarioAtendimento) {
        if(horarioAtendimento == null){
            return;
        }
        this.horariosAtendimento.add(horarioAtendimento);
    }

    public void remover(Horario horarioAtendimento) {
        this.horariosAtendimento = null;
    }
}
