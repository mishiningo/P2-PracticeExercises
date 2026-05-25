package ipleiria.pt;

public abstract class Descritor {
    protected String nome;

    public Descritor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
