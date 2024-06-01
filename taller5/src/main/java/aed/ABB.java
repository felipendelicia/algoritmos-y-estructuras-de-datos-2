package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo root;
    private int length;

    private class Nodo {
        private T value;
        private Nodo left_child;
        private Nodo right_child;

        public Nodo(T value) {
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }
    }

    public ABB() {
        this.root = null;
        this.length = 0;
    }

    public int cardinal() {
        return this.length;
    }

    public T minimo() {
        if (this.root == null)
            throw new NoSuchElementException("El árbol está vacío.");
        Nodo actual_node = this.root;
        while (actual_node.left_child != null) {
            actual_node = actual_node.left_child;
        }
        return actual_node.value;
    }

    public T maximo() {
        if (this.root == null)
            throw new NoSuchElementException("El árbol está vacío.");
        Nodo actual_node = this.root;
        while (actual_node.right_child != null) {
            actual_node = actual_node.right_child;
        }
        return actual_node.value;
    }

    private boolean recursive_insert(Nodo node, T elem) {
        if (elem.compareTo(node.value) < 0) {
            if (node.left_child == null) {
                node.left_child = new Nodo(elem);
                this.length += 1;
                return true;
            } else {
                return recursive_insert(node.left_child, elem);
            }
        } else if (elem.compareTo(node.value) > 0) {
            if (node.right_child == null) {
                node.right_child = new Nodo(elem);
                this.length += 1;
                return true;
            } else {
                return recursive_insert(node.right_child, elem);
            }
        } else {
            return false;
        }
    }

    public void insertar(T elem) {
        if (this.root == null) {
            this.root = new Nodo(elem);
            this.length += 1;
            return;
        }
        recursive_insert(this.root, elem);
    }

    private boolean recursive_in(Nodo node, T elem) {
        if (node == null) {
            return false;
        }
        if (elem.compareTo(node.value) == 0) {
            return true;
        }
        if (elem.compareTo(node.value) < 0) {
            return recursive_in(node.left_child, elem);
        } else {
            return recursive_in(node.right_child, elem);
        }
    }

    public boolean pertenece(T elem) {
        if (this.root == null)
            return false;
        return recursive_in(this.root, elem);

    }

    private T minimoValor(Nodo node) {
        T minimo = node.value;
        while (node.left_child != null) {
            node = node.left_child;
            minimo = node.value;
        }
        return minimo;
    }

    public void eliminar(T elem) {
        if (this.root == null)
            return;

        this.root = recursive_delete(this.root, elem);
        if (this.root != null) {
            this.length--;
        } else {
            this.length = 0;
        }
    }

    private Nodo recursive_delete(Nodo node, T elem) {
        if (node == null)
            return null;

        if (elem.compareTo(node.value) < 0) {
            node.left_child = recursive_delete(node.left_child, elem);
        } else if (elem.compareTo(node.value) > 0) {
            node.right_child = recursive_delete(node.right_child, elem);
        } else {
            // Caso 1: Nodo sin hijos o con un solo hijo
            if (node.left_child == null) {
                return node.right_child;
            } else if (node.right_child == null) {
                return node.left_child;
            }
            // Caso 2: Nodo con dos hijos
            node.value = minimoValor(node.right_child);
            node.right_child = recursive_delete(node.right_child, node.value);
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, sb);
        sb.insert(0, "{");
        sb.append("}");
        return sb.toString();
    }

    private void toStringRec(Nodo node, StringBuilder sb) {
        if (node != null) {
            toStringRec(node.left_child, sb);
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(node.value.toString());
            toStringRec(node.right_child, sb);
        }
    }

    private class ABB_Iterador implements Iterador<T> {

        private Stack<Nodo> stack;
        private Nodo actual;

        public ABB_Iterador() {
            stack = new Stack<>();
            actual = root;
            while (actual != null) {
                stack.push(actual);
                actual = actual.left_child;
            }
        }

        public boolean haySiguiente() {
            return !stack.isEmpty();
        }

        public T siguiente() {
            if (!haySiguiente()) {
                throw new NoSuchElementException("No hay más elementos");
            }
            Nodo nodo = stack.pop();
            T valor = nodo.value;
            if (nodo.right_child != null) {
                nodo = nodo.right_child;
                while (nodo != null) {
                    stack.push(nodo);
                    nodo = nodo.left_child;
                }
            }
            return valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}
