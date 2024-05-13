package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo cabeza;
    private Nodo cola;
    private Integer longitud;

    private class Nodo {
        private T data;
        private Nodo next;
        private Nodo prev;

        public Nodo(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public T data() {
            return this.data;
        }

        public Nodo next() {
            return this.next;
        }

        public Nodo prev() {
            return this.prev;
        }

        public void setData(T new_data) {
            this.data = new_data;
        }

        public void setNext(Nodo next) {
            this.next = next;
        }

        public void setPrev(Nodo prev) {
            this.prev = prev;
        }
    }

    public ListaEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo(elem);

        if (this.cabeza == null) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            this.cabeza.setPrev(nuevoNodo);
            nuevoNodo.setNext(this.cabeza);
            this.cabeza = nuevoNodo;
        }

        this.longitud += 1;
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);

        if (this.cola == null) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            this.cola.setNext(nuevoNodo);
            nuevoNodo.setPrev(this.cola);
            this.cola = nuevoNodo;
        }

        this.longitud += 1;
    }

    public T obtener(int i) {
        Nodo n = obtenerNodo(i);
        return n.data();
    }

    private Nodo obtenerNodo(int i) {
        Nodo n = this.cabeza;
        while (i != 0) {
            n = n.next();
            i -= 1;
        }
        return n;
    }

    public void eliminar(int i) {
        if (this.longitud == 1) {
            this.cabeza = null;
            this.cola = null;
        } else if (i == 0) {
            this.cabeza = this.cabeza.next();
            this.cabeza.setPrev(null);
        } else if (i == this.longitud - 1) {
            this.cola = this.cola.prev();
            this.cola.setNext(null);
        } else {
            Nodo Nodo = this.obtenerNodo(i);
            Nodo.prev().setNext(Nodo.next());
            Nodo.next().setPrev(Nodo.prev());
        }
        this.longitud -= 1;
    }

    public void modificarPosicion(int indice, T elem) {
        obtenerNodo(indice).setData(elem);
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<>();
        Nodo actual = cabeza;

        while (actual != null) {
            nuevaLista.agregarAtras(actual.data());
            actual = actual.next();
        }

        return nuevaLista;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.longitud = lista.longitud;
        if (lista.longitud == 0) {
            this.cabeza = null;
            this.cola = null;
            return;
        }

        this.cabeza = new Nodo(lista.cabeza.data());
        Nodo nuevoNodo = this.cabeza;
        Nodo nodoOriginal = lista.cabeza.next();

        while (nodoOriginal != null) {
            nuevoNodo.next = new Nodo(nodoOriginal.data());
            nuevoNodo.next.prev = nuevoNodo;
            nuevoNodo = nuevoNodo.next;
            nodoOriginal = nodoOriginal.next;
        }

        this.cola = nuevoNodo;
    }

    @Override
    public String toString() {
        Nodo n = this.cabeza;
        String response = "[";

        while (n.next() != null) {
            response += n.data().toString() + ", ";
            n = n.next();
        }

        response += this.cola.data().toString() + "]";

        return response;
    }

    private class ListaIterador implements Iterador<T> {
        private Integer indice;

        public ListaIterador() {
            this.indice = 0;
        }

        public boolean haySiguiente() {
            return indice < longitud();
        }

        public boolean hayAnterior() {
            return indice > 0;
        }

        public T siguiente() {
            indice += 1;
            return obtener(indice - 1);
        }

        public T anterior() {
            indice -= 1;
            return obtener(indice);
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
