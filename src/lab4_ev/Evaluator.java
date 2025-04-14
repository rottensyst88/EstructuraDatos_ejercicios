package lab4_ev;

public class Evaluator {

    public static boolean debug_insert_min    = true;
    public static boolean debug_insert_max    = true;
    public static boolean debug_insert_middle = true;
    public static boolean debug_insert_full   = true;

    public static void main(String[] args) {
        int puntaje = 0;

        System.out.println("Iniciando evaluación. \n");
        
        System.out.println("Testeando función insert_head: ");
        if(test_insert_head())
            puntaje += 20;

        System.out.println("Testeando función insert_min: ");
        if(test_insert_min())
            puntaje += 20;

        System.out.println("Testeando función insert_max: ");
        if(test_insert_max())
            puntaje += 20;

        System.out.println("Testeando función insert_middle: ");
        if(test_insert_middle())
            puntaje += 20;

        System.out.println("Testeando función insert_full: ");
        if(test_insert_full())
            puntaje += 20;

        System.out.println("Testeando función delete: ");

        System.out.println("Evaluación terminada.");

        

        double nota = calcularNota(puntaje,100);

        System.out.println("Puntaje obtenido: " + puntaje + '/' + 100);
        System.out.println("Nota: " + nota);      
    }

    private static boolean test_insert_head() {
        try {
            SLL list = new SLL();
            list.insert(5);
    
            int expected = 5;
            int actual = list.head.val;
    
            return ev("Test_Insert_Head", actual == expected);
        } catch (Exception e) {
            System.out.println("[✘] Test_Insert_head falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_insert_min() {
        try {
            SLL list = new SLL();
            int[] unsorted = {47, 19, 5};
            int[] sorted = {5, 19, 47};

            if(debug_insert_min) {
                for(int i=0; i<unsorted.length; i++) {
                    System.out.println("Insertando el valor " + unsorted[i] + ": ");
                        
                    list.insert(unsorted[i]);
                    
                    System.out.println("Insert ejecutado sin errores. Imprimiendo la lista: \n");        
                    list.print();
                    System.out.println("\n");
                }
            } else {
                for(int i=0; i<unsorted.length; i++)
                    list.insert(unsorted[i]);
            }
    
            boolean approved = true;
            ListNode it = list.head;

            for(int i=0; i<sorted.length; i++) {
                if(it.val != sorted[i]){
                    approved = false;
                    break;
                }
                it = it.next;
            }
    
            return ev("Test_Insert_min", approved);
        } catch (Exception e) {
            System.out.println("[✘] Test_Insert_min falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_insert_max() {
        try {
            SLL list = new SLL();
            int[] inputs = {5, 13, 47};
            
            if(debug_insert_max) {
                for(int i=0; i<inputs.length; i++) {
                    System.out.println("Insertando el valor " + inputs[i] + ": ");
                        
                    list.insert(inputs[i]);
                    
                    System.out.println("Insert ejecutado sin errores. Imprimiendo la lista: \n");        
                    list.print();
                    System.out.println("\n");
                }
            } else {
                for(int i=0; i<inputs.length; i++)
                    list.insert(inputs[i]);
            }
    
            boolean approved = true;
            ListNode it = list.head;

            for(int i=0; i<inputs.length; i++) {
                if(it.val != inputs[i]){
                    approved = false;
                    break;
                }
                it = it.next;
            }
    
            return ev("Test_Insert_max", approved);
        } catch (Exception e) {
            System.out.println("[✘] Test_Inser_max falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_insert_middle() {
        try {
            SLL list = new SLL();
            int[] unsorted = {9, 71, 22};
            int[] sorted = {9, 22, 71};
            
            if(debug_insert_middle) {
                for(int i=0; i<sorted.length; i++) {
                    System.out.println("Insertando el valor " + unsorted[i] + ": ");
                        
                    list.insert(unsorted[i]);
                    
                    System.out.println("Insert ejecutado sin errores. Imprimiendo la lista: \n");        
                    list.print();
                    System.out.println("\n");
                }
            } else {
                for(int i=0; i<sorted.length; i++)
                    list.insert(unsorted[i]);
            }

            boolean approved = true;
            ListNode it = list.head;

            for(int i=0; i<sorted.length; i++) {
                if(it.val != sorted[i]){
                    approved = false;
                    break;
                }
                it = it.next;
            }
    
            return ev("Test_Insert_middle", approved);
        } catch (Exception e) {
            System.out.println("[✘] Test_Insert_middle falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_insert_full() {
        try {
            SLL list = new SLL();
            int[] unsorted = {9,1,7,43,15,-1000,3};
            int[] sorted = {-1000, 1, 3, 7, 9, 15, 43};
    
            if(debug_insert_full) {
                for(int i=0; i<sorted.length; i++) {
                    System.out.println("Insertando el valor " + unsorted[i] + ": ");
                        
                    list.insert(unsorted[i]);
                    
                    System.out.println("Insert ejecutado sin errores. Imprimiendo la lista: \n");        
                    list.print();
                    System.out.println();
                }
            } else {
                for(int i=0; i<sorted.length; i++)
                    list.insert(unsorted[i]);
            }
            
            boolean approved = true;
            ListNode it = list.head;

            for(int i=0; i<sorted.length; i++) {
                if(it.val != sorted[i]){
                    approved = false;
                    break;
                }
                it = it.next;
            }
    
            return ev("Test_Insert", approved);
        } catch (Exception e) {
            System.out.println("[✘] Test_Insert_full falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean ev(String testName, boolean condition) {
        if (condition) {
            System.out.println("[✔] " + testName + " pasó.");
            return true;
        } else {
            System.out.println("[✘] " + testName + " falló.");
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