package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    boolean esPar(int n) {
        return n % 2 == 0;
    }

    boolean esBisiesto(int n) {
        boolean is4Multiple = n % 4 == 0;
        boolean is100Multiple = n % 100 == 0;
        boolean is400Multiple = n % 400 == 0;
        return (is400Multiple) || (is4Multiple && !is100Multiple);
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n == 0)
            return 1;
        return n * factorialRecursivo(n - 1);
    }

    boolean esPrimo(int n) {
        if (n == 0 || n == 1)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int numero : numeros) {
            res += numero;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado)
                return i;
        }
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int numero : numeros) {
            if (esPrimo(numero))
                return true;
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int numero : numeros) {
            if (!esPar(numero))
                return false;
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length())
            return false; // Check if s1 is more bigger than s2
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length())
            return false; // Check if s1 is more bigger than s2
        int lengthDiference = s2.length() - s1.length();
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (s2.charAt(i + lengthDiference) != s1.charAt(i)) // adjust the length diferent
                return false;
        }
        return true;
    }

}