package ejercicioLab25abril;

public class Stack extends LinkedList {
    public void push(TreeNode tree) {
        Item newNode = new Item(tree);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
        }    
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    public TreeNode pop() {  
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
