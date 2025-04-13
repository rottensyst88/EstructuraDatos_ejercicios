package lab3;

public class DLL extends DLLBase {

    @Override
    public void insert(int val) {
        ListNode nodoNuevo = new ListNode(val);

        if (estaVacia()) {
            head = nodoNuevo;
            return;
        }

        ListNode nodoActual = head; // guarda los datos del nodo actual
        head = nodoNuevo;
        head.next = nodoActual;
        head.next.prev = head;
    }

    @Override
    public void delete(int val) {
        ListNode valorEliminar = new ListNode(val);

        if(estaVacia()) {
            return;
        }

        for(ListNode x = head; x != null; x = x.next) {
            if (x.val == val) {
                if (x.prev == null) { // Es el de la cabeza
                    head = x.next;
                }else{
                    x.prev.next = x.next;
                }

                if (x.next == null) { // Es el de la cola
                    tail = x.prev;
                }else{
                    x.next.prev = x.prev;
                }

                return;
            }
        }
    }

    @Override
    public int search(int val) {
        int contador = 0;

        for(ListNode x = head; x != null; x = x.next) {
            if(x.val == val){
                return contador;
            }
            contador++;
        }

        return -1;
    }

    @Override
    public boolean isPalindrome() {

        return false;
    }

}
