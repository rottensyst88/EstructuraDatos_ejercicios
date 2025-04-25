package ejercicioLab25abril;

public class Queue extends LinkedList {  
    public void add(TreeNode tree) {
        Item newNode = new Item(tree);
        if(tail == null) {
            head = newNode;
            tail = newNode;
            size++;
        }    
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public TreeNode poll() {  
        if (isEmpty()) {
            throw new RuntimeException("The list is empty");
        }
    
        TreeNode tree = head.node;
        head = head.next;
        if(head == null)
            tail = null;
    
        size--;
        return tree;
    }
}