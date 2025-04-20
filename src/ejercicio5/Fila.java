package ejercicio5;
import ejercicio3.Overflow;
import ejercicio3.Underflow;

public class Fila {
    int rear, front, tamanhoActual, tam;
    int[] A;

    Fila(int n) {
        front = 0;
        rear = front - 1;
        A = new int[tam = n];
        tamanhoActual = 0;
    }

    void Insert(int m) throws Overflow {
        if (isFull()) throw new Overflow("Fila Llena");
        else {
            rear = (rear + 1) % tam;
            A[rear] = m;
            tamanhoActual++;
        }
    }

    int Delete() throws Underflow {
        if (isEmpty()) throw new Underflow("Fila Vacia");
        else {
            int m = A[front];
            front = (front + 1) % tam;
            tamanhoActual--;
            return m;
        }
    }

    int Size() {
        return tamanhoActual;
    }

    boolean isFull() {
        return tamanhoActual >= tam;
    }

    boolean isEmpty() {
        return tamanhoActual == 0;
    }
}

