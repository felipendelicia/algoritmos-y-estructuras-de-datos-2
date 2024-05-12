package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha.dia(), fecha.mes());
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return new Fecha(this.fecha.dia(), this.fecha.mes());
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        String str_fecha = this.fecha().toString();
        String str_horario = this.horario().toString();
        return this.mensaje + " @ " + str_fecha + " " + str_horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }
        if (!(otro instanceof Recordatorio)) {
            return false;
        }

        Recordatorio otroRecordatorio = (Recordatorio) otro;

        return this.fecha().equals(otroRecordatorio.fecha()) &&
                this.horario().equals(otroRecordatorio.horario()) &&
                this.mensaje().equals(otroRecordatorio.mensaje());
    }
}
