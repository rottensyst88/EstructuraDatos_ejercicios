package ejercicioLab25abril;

public class GTree extends GTreeBase {

    //Las implementaciones deben utilllizar la clase Queue y no recursividad.

    @Override
    public Queue LevelOrder() {
        Queue q = new Queue();
        TreeNode raiz_og = root;

        if (root == null) {
            return null;
        }

        if (root.sibling == null && root.child == null) {
            q.add(root);
            return q;
        }

        if (root.child.sibling == null) {
            q.add(root);

            for (TreeNode x = root.child; x != null; x = x.child) {
                q.add(x);
            }
            return q;
        } else if (root.child.child == null) {
            q.add(root);

            for (TreeNode x = root.child; x != null; x = x.sibling) {
                q.add(x);
            }
            return q;
        }

        q.add(root);
        TreeNode x = root.child;
        int c = 0;

        while (x != null) {
            q.add(x);

            if (x.sibling == null) {
                c++;
                x = root.child;

                for (int z = 1; z < c; z++) {
                    x = x.sibling;
                }
                x = x.child;
            } else {
                x = x.sibling;
            }
        }

        return q;
    }

    @Override
    public Queue deleteLeafs() {
        return null;
    }
}