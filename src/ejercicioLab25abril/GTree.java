package ejercicioLab25abril;

public class GTree extends GTreeBase {

    @Override
    public Queue LevelOrder(){
        Queue resultado = new Queue();

        if(root == null) return null;

        Queue auxiliar = new Queue();
        auxiliar.add(root);

        while(!auxiliar.isEmpty()){
            TreeNode curr = auxiliar.poll();
            resultado.add(curr);

            if (curr.child != null){
                auxiliar.add(curr.child);
            }

            for (TreeNode Hrmano = curr.child; Hrmano != null && Hrmano.sibling != null; Hrmano = Hrmano.sibling){
                auxiliar.add(Hrmano.sibling);
            }
        }

        return resultado;
    }


    public Queue NotLevelOrder() {
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