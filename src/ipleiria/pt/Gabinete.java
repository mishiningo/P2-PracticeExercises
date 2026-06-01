package ipleiria.pt;

import java.util.LinkedList;

public class Gabinete<TFuncionario extends Funcionario> extends Divisao{

    LinkedList<TFuncionario> funcionarios;

    public Gabinete(String nome, boolean aberta) {
        super(nome, aberta);
        this.funcionarios = new LinkedList<>();
    }

    public void adicionar(TFuncionario funcionario){
        if  (funcionario == null){
            return;
        }
        if (funcionarios.contains(funcionario)){
            return;
        }
        funcionarios.add(funcionario);
        funcionario.setGabinete(this);
    }

    public void remover(TFuncionario funcionario){
        if (funcionarios.contains(funcionario) && funcionario != null){
            funcionarios.remove(funcionario);
            funcionario.removeGabinete();
        }
    }

    public LinkedList<TFuncionario> getFuncionarios() {
        return funcionarios;
    }
}
