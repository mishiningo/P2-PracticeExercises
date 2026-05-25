package ipleiria.pt;

import java.util.LinkedList;

public class GabineteSeguranca extends Divisao {
    private LinkedList<Seguranca> segurancas;;

    public GabineteSeguranca(String nome, boolean aberta) {
        super(nome, aberta);
        this.segurancas = new LinkedList<>();
    }

    public LinkedList<Seguranca> getSegurancas() {
        return segurancas;
    }

    public void adicionar(Seguranca seguranca) {
        if (seguranca == null) {
            return;
        }
        if (segurancas.contains(seguranca)){
            System.out.println("Segurança já existente");
            return;
        }
        this.segurancas.add(seguranca);
        seguranca.setGabinete(this);
    }

    public void remover(Seguranca seguranca) {
        if (seguranca == null) {
            return;
        }
        if (!segurancas.contains(seguranca)){
            System.out.println("Segurança já inexistente");
        }
        this.segurancas.remove(seguranca);
        seguranca.setGabinete(null);
    }
}
