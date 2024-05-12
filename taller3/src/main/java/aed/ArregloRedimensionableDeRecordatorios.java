package aed;

import java.util.Arrays;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] recordatorios;
    private int longitud;

    public ArregloRedimensionableDeRecordatorios() {
        this.longitud = 0;
        this.recordatorios = new Recordatorio[5];
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorios = Arrays.copyOf(vector.recordatorios, vector.recordatorios.length);
        this.longitud = vector.longitud;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        if (this.longitud == this.recordatorios.length) {
            this.recordatorios = Arrays.copyOf(recordatorios, recordatorios.length * 2);
        }
        this.recordatorios[this.longitud] = i;
        this.longitud += 1;
    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        if (this.longitud > 0) {
            this.longitud -= 1;
            this.recordatorios[this.longitud] = null;
        }
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        if (0 <= indice && indice < this.longitud) { // Si el indice esta en rango...
            this.recordatorios[indice] = valor;
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }

}
