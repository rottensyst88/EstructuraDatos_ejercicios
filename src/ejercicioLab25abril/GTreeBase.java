package ejercicioLab25abril;

public class GTreeBase { 
    
    public TreeNode root;
    
    public GTreeBase() {
        root = null;
    }

    public void setRoot(String rootName) {
        root = new TreeNode(rootName);
    }

    public TreeNode getRoot() { 
        return root; 
    }

    public void insertChild(String parentName, String newNodeName) {
        TreeNode parentNode = simpleFindNode(parentName);
        insertChild(parentNode, newNodeName);
    }

    public void insertChild(TreeNode node, String newNodeName) {
        if (node.child == null) {
            node.child = new TreeNode(newNodeName);
        } 
        else {
            insertSibling(node.child, newNodeName);
        }
    }

    public void insertSibling(String nodeName, String newNodeName) {
        TreeNode node = simpleFindNode(nodeName);
        insertSibling(node, newNodeName);
    }

    public void insertSibling(TreeNode node, String name) {
        TreeNode it = node;
        while(it.sibling != null) 
            it = it.sibling;

        it.sibling = new TreeNode(name);
    }

    public TreeNode simpleFindNode(String name) {
        if(root == null) 
            return null;

        Stack s = new Stack();
        s.push(root);

        while(!s.isEmpty()) {
            TreeNode current = s.pop();

            if(current.name.equals(name))
                return current;

            if(current.sibling != null) 
                s.push(current.sibling);
            if(current.child != null)
                s.push(current.child);
        }

        return null;
    }

    public Queue LevelOrder() {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public Queue deleteLeafs() {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
