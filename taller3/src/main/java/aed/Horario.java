package aed;

public class Horario {
    private Integer hora;
    private Integer minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        String str_hora = this.hora.toString();
        String str_minutos = this.minutos.toString();
        return str_hora + ":" + str_minutos;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro)
            return true;
        if (!(otro instanceof Horario))
            return false;

        Horario otroHorario = (Horario) otro;

        return this.hora.equals(otroHorario.hora) && this.minutos.equals(otroHorario.minutos);
    }

}
