package ipleiria.pt;

import java.util.LinkedList;

public interface Funcionario<TGabinete extends Gabinete, TDivisao extends Divisao> {
    void abrir(TDivisao divisao);
    void fechar(TDivisao divisao);
    void abrirGabinete();
    void fecharGabinete();
    void setGabinete(TGabinete gabinete);
    void removeGabinete();
    LinkedList<Horario> getHorariosAtendimento();
    TGabinete getGabinete();
    void adicionar(Horario horarioAtendimento);
    void remover(Horario horarioAtendimento);

}
