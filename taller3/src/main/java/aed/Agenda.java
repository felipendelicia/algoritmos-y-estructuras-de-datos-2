package aed;

public class Agenda {

    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = fechaActual;
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String response = "";
        response += this.fechaActual.toString() + "\n";
        response += "=====" + "\n";

        for (Integer i = 0; i < this.recordatorios.longitud(); i++) {
            Recordatorio recordatorio = this.recordatorios.obtener(i);
            if (recordatorio.fecha().equals(this.fechaActual)) {
                response += recordatorio.toString() + "\n";
            }
        }

        return response;

    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();

    }

    public Fecha fechaActual() {
        return this.fechaActual;
    }

}
