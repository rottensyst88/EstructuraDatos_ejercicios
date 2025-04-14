package lab4_ev;

public class SLLBase {
    public ListNode head;

    public int size() {
        int size = 0;
        ListNode iterator = this.head;
        
        while(iterator != null) {
            size++;
            iterator = iterator.next;
        }
        
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void print() {
        ListNode actual = head;
        System.out.print("[ " + actual.val);
        actual =  actual.next;

        while (actual != null) {
            System.out.print(", " + actual.val);
            actual = actual.next;
        }
        System.out.println(" ]");
    }

    public void insert(int val) {
        throw new UnsupportedOperationException("Método no implementado");
    }

}
