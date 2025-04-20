package ejercicio3;

public class Pila {
    private int tope;
    private int tamanho;
    private int[] elemento;

    public Pila(int tam) {
        tamanho = tam;
        elemento = new int[tam];
        tope = -1;
    }

    void Push(int x) throws Overflow {
        if (isFull()) throw new Overflow("ejercicio3.Pila Llena");
        else elemento[++tope] = x;
    }

    int Pop() throws Underflow {
        if (isEmpty()) throw new Underflow("ejercicio3.Pila Vacia");
        else return elemento[tope--];
    }

    private boolean isFull() {
        return (tope + 1 >= tamanho);
    }

    private boolean isEmpty() {
        return (tope < 0);
    }
}