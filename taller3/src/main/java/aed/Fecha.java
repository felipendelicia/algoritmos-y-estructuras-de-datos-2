package aed;

public class Fecha {
    private Integer dia;
    private Integer mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    @Override
    public String toString() {
        String str_mes = this.mes.toString();
        String str_dia = this.dia.toString();
        return str_dia + "/" + str_mes;
    }

    @Override
    public boolean equals(Object otra) {
        if (this == otra) {
            return true;
        }

        if (!(otra instanceof Fecha)) {
            return false;
        }

        Fecha otraFecha = (Fecha) otra;

        return this.dia.equals(otraFecha.dia) && this.mes.equals(otraFecha.mes);
    }

    public void incrementarDia() {
        if (this.dia == diasEnMes(this.mes)) { // Si se alcanzan los dias maximos
            this.dia = 1;
            if (this.mes == 12) // Si se alcanzan los meses maximos
                this.mes = 1;
            else
                this.mes += 1;
        } else
            this.dia += 1;
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
