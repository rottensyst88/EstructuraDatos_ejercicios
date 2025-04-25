package ejercicioLab25abril;

public class LinkedList {
    public Item head;
    public int size;
    public Item tail;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Item actual = head;
        System.out.print("[ " + actual.node.name);
        actual = actual.next;

        while (actual != null) {
            System.out.print(", " + actual.node.name);
            actual = actual.next;
        }
        System.out.println(" ]");
    }

    int getSize() {
        return size;
    }
}
