package ejercicioLab25abril;

public class TreeNode {
    String name;
    TreeNode child;
    TreeNode sibling;
    
    public TreeNode() {
        name = "";
        child = null;
        sibling = null;
    }

    public TreeNode(String name) {
        this.name = name;
        child = null;
        sibling = null;
    }
}
