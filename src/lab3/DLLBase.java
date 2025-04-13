package lab3;

public class DLLBase {
    public ListNode head;
    public ListNode tail;

    public int size() {
        int size = 0;
        ListNode iterator = this.head;
        
        while(iterator != null) {
            size++;
            iterator = iterator.next;
        }
        
        return size;
    }
    
    public boolean estaVacia() {
        return head == null;
    }
    
    public void imprimir() {
        ListNode actual = head;
        while (actual != null) {
            System.out.print(actual.val + " ");
            actual = actual.next;
        }
        System.out.println();
    }

    public void insert(int val) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public void delete(int val) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public int search(int val) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    // Actividad extra

    public boolean isPalindrome() {
        throw new UnsupportedOperationException("Método no implementado");
    }


}
