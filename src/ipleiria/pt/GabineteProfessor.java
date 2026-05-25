package ipleiria.pt;

import java.util.LinkedList;

public class GabineteProfessor extends Divisao {
    private LinkedList<Professor> professores;

    public GabineteProfessor(String nome, boolean aberta) {
        super(nome, aberta);
    }

    public LinkedList<Professor> getProfessores() {
        return professores;
    }

    public void adicionarProfessores(Professor professor) {
        if (professor == null){
            return;
        }
        if (this.professores == null) {
            this.professores = new LinkedList<>();
        }
        if(this.professores.contains(professor)){
            System.out.println("Professor já associado");
            return;
        }
        this.professores.add(professor);
        professor.setGabineteProfessor(this);
    }

    public void removerProfessores(Professor professor) {
        if (professor == null){
            return;
        }
        if(!this.professores.contains(professor)){
            System.out.println("Professor já desassociado");
            return;
        }
        this.professores.remove(professor);
        professor.setGabineteProfessor(null);
    }
}
