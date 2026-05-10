package ipleiria.pt;

public class Horario {

    //Atributos
    private DiaSemana diaSemana;
    private int horaInicio;
    private int duracao;

    //Também era possível pedir uma String e this.diaSemana = DiaSemana.valueOf(diaSemana.toUpperCase())
    public Horario(DiaSemana diaSemana, int horaInicio, int duracao) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobreposto(Horario horario) {
            //Imagine um horario H1 e outro H2
            //Uma aula é sobreposta se o fim de H1 for maior que o inicio de H2 e se o começo de H1 for menor que o fim de H2
            return horario.getDiaSemana().equals(diaSemana) && horario.getHoraInicio() + horario.getDuracao() > horaInicio && horaInicio + duracao > horario.getHoraInicio();
    }
}
