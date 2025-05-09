package desarrolloTestEj2;

public class Lista {

    public class Nodo {
        int objeto;
        Nodo siguiente;

        Nodo(int i, Nodo s) {
            objeto = i;
            siguiente = s;
        }
    }

    Nodo head;

    public Lista() {
        head = null;
    }

    public static boolean SubLista(Lista l1, Lista l2) {
        /*

        Nodo ls2 = l2.head;

        while (ls2 != null) {
            Nodo temp2 = ls2;
            Nodo ls1 = l1.head;
            while (ls1 != null && temp2.objeto == ls1.objeto) {
                temp2 = temp2.siguiente;
                ls1 = ls1.siguiente;
            }
            if (ls1 == null) {
                return true; // Se encontró la sublista
            }
            ls2 = ls2.siguiente;
        }

        return false; // No se encontró la sublista

         */
        Nodo z = null;
        for (Nodo x = l2.head; x.siguiente != null; x = x.siguiente) {
            if (x.objeto == l1.head.objeto) {
                z = x;
                break;
            }
        }
        return true;
    }
}