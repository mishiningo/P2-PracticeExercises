package ipleiria.pt;

public abstract class Divisao extends Descritor {
    protected boolean aberta;

    public Divisao(String nome, boolean aberta) {
        super(nome);
        this.aberta = aberta;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

}
