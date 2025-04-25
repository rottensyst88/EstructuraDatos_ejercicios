package ejercicioLab25abril;

public class Evaluator {

    public static void main(String[] args) {
        int puntaje = 0;

        System.out.println("Iniciando evaluación. \n");
        
        System.out.println("Testeando función level_order en un arbol vacio: ");
        if(test_empty_level_order())
            puntaje += 10;

        System.out.println("Testeando función level_order en un arbol solo con raiz: ");
        if(test_root_level_order())
            puntaje += 10;

        System.out.println("Testeando función level_order cuando no hay hermanos: ");
        if(test_childs_level_order())
            puntaje += 20;

        System.out.println("Testeando función level_order en un arbol donde todos son hijos de la raiz: ");
        if(test_sibling_level_order())
            puntaje += 20;

        System.out.println("Testeando función level_order en un arbol completo: ");
        if(test_full_level_order())
            puntaje += 40;

        System.out.println("Evaluación terminada.");        

        double nota = calcularNota(puntaje,100);

        System.out.println("Puntaje obtenido: " + puntaje + '/' + 100);
        System.out.println("Nota: " + nota + "\n\n");   
        

        if(nota == 7) {
            System.out.println("Testeando actividad extra deleteLeafs: ");

            System.out.println("Iniciando evaluación de la función deleteLeads. \n");

            int puntaje_extra = 0;

            if(test_deleteLeafs_return())
                puntaje_extra += 30;

            if(test_deleteLeafs_tree())
                puntaje_extra += 70;

            System.out.println("Evaluación terminada.");

            System.out.println("Puntaje obtenido: " + puntaje_extra + '/' + 100);
            System.out.println("Nota: " + calcularNota(puntaje_extra, 100));
        }
    }

    private static boolean test_empty_level_order() {
        try {
            GTree tree = new GTree();
            Queue result = tree.LevelOrder();

            return ev("test_empty_level_order", result == null);
        } catch (Exception e) {
            System.out.println("[✘] test_empty_level_order falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_root_level_order() {
        try {
            GTree tree = new GTree();
            tree.setRoot("A");
    
            Queue result = tree.LevelOrder();
    
            boolean condition = result != null && result.poll().name.equals("A") && result.isEmpty();
            return ev("test_root_level_order", condition);
    
        } catch (Exception e) {
            System.out.println("[✘] test_root_level_order falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_childs_level_order() {
        try {
            GTree tree = new GTree();
            tree.setRoot("A");
            tree.insertChild("A", "C");
            tree.insertChild("C", "H");
            tree.insertChild("H", "I");
    
            Queue result = tree.LevelOrder();
    
            result.print();

            boolean condition = result != null &&
                result.poll().name.equals("A") &&
                result.poll().name.equals("C") &&
                result.poll().name.equals("H") &&
                result.poll().name.equals("I") &&
                result.isEmpty();
    
            return ev("test_childs_level_order", condition);
    
        } catch (Exception e) {
            System.out.println("[✘] test_childs_level_order falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_sibling_level_order() {
        try {
            GTree tree = new GTree();
            tree.setRoot("A");
            tree.insertChild("A", "B");
            tree.insertChild("A", "C");
            tree.insertChild("A", "D");
    
            Queue result = tree.LevelOrder();
    
            result.print();

            boolean condition = result != null &&
                result.poll().name.equals("A") &&
                result.poll().name.equals("B") &&
                result.poll().name.equals("C") &&
                result.poll().name.equals("D") &&
                result.isEmpty();
    
            return ev("test_sibling_level_order", condition);
    
        } catch (Exception e) {
            System.out.println("[✘] test_sibling_level_order falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_full_level_order() {
        try {
            GTree tree = new GTree();
            tree.setRoot("A");
            tree.insertChild("A", "B");
            tree.insertChild("A", "C");
            tree.insertSibling("C", "D");
            tree.insertChild("B", "E");
            tree.insertChild("C", "F");
            tree.insertSibling("F", "G");
            tree.insertChild("C", "H");
            tree.insertChild("H", "I");

            Queue result = tree.LevelOrder();
    
            result.print();

            boolean condition = result != null &&
                result.poll().name.equals("A") &&
                result.poll().name.equals("B") &&
                result.poll().name.equals("C") &&
                result.poll().name.equals("D") &&
                result.poll().name.equals("E") &&
                result.poll().name.equals("F") &&
                result.poll().name.equals("G") &&
                result.poll().name.equals("H") &&
                result.poll().name.equals("I") &&
                result.isEmpty();
    
            return ev("test_full_level_order", condition);
    
        } catch (Exception e) {
            System.out.println("[✘] test_full_level_order falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_deleteLeafs_return() {
        try {
            GTree tree = new GTree();
            tree.setRoot("A");
            tree.insertChild("A", "B");
            tree.insertChild("A", "C");
            tree.insertSibling("C", "D");
            tree.insertChild("B", "E");
            tree.insertChild("C", "F");
            tree.insertSibling("F", "G");
            tree.insertChild("C", "H");
            tree.insertChild("H", "I");

            Queue result = tree.deleteLeafs();
            System.out.println("Imprimiendo la cola de hojas retornada por deleteLeafs");
            result.print();

            boolean condition = result != null &&
                result.poll().name.equals("D") &&
                result.poll().name.equals("E") &&
                result.poll().name.equals("F") &&
                result.poll().name.equals("G") &&
                result.poll().name.equals("I") &&
                result.isEmpty();
    
            return ev("test_deleteLeafs_return", condition);
    
        } catch (Exception e) {
            System.out.println("[✘] test_full_level_order falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_deleteLeafs_tree() {
        try {
            GTree tree = new GTree();
            tree.setRoot("A");
            tree.insertChild("A", "B");
            tree.insertChild("A", "C");
            tree.insertSibling("C", "D");
            tree.insertChild("B", "E");
            tree.insertChild("C", "F");
            tree.insertSibling("F", "G");
            tree.insertChild("C", "H");
            tree.insertChild("H", "I");

            Queue leafs = tree.deleteLeafs();
    
            Queue result_GTree = tree.LevelOrder(); 
            System.out.println("Imprimiendo el estado final del \'arbol en LevelOrder");
            result_GTree.print();

            boolean condition = result_GTree != null &&
                result_GTree.poll().name.equals("A") &&
                result_GTree.poll().name.equals("B") &&
                result_GTree.poll().name.equals("C") &&
                result_GTree.poll().name.equals("H") &&
                result_GTree.isEmpty();
    
            return ev("test_deleteLeafs_return", condition);
    
        } catch (Exception e) {
            System.out.println("[✘] test_full_level_order falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean ev(String testName, boolean condition) {
        if (condition) {
            System.out.println("[✔] " + testName + " pasó. \n");
            return true;
        } else {
            System.out.println("[✘] " + testName + " falló. \n");
            return false;
        }
    }


    private static double calcularNota(int puntajeObtenido, int puntajeTotal) {
        if (puntajeObtenido <= 0) return 1.0;
        if (puntajeObtenido >= puntajeTotal) return 7.0;
        
        if (puntajeObtenido <= 60) {
            return 1.0 + ((double) puntajeObtenido / 60) * (4.0 - 1.0);
        } else {
            return 4.0 + ((double) (puntajeObtenido - 60) / (puntajeTotal - 60)) * (7.0 - 4.0);
        }
    }

}