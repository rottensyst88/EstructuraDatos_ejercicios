package lab3;

public class Evaluator {
    public static void main(String[] args) {
        boolean[] grades = new boolean[4]; 

        System.out.println("Iniciando evaluación. \n");
        
        System.out.println("Testeando función insertHead: ");
        grades[0] = test_insert();

        System.out.println("Testeando función searchVal (true): ");
        grades[1] = test_search_true();

        System.out.println("Testeando función searchVal (false): ");
        grades[2] = test_search_false();

        System.out.println("Testeando función deleteVal: ");
        grades[3] = test_delete();

        System.out.println("Evaluación terminada.");

        int puntaje = 0;

        for (byte i = 0; i < grades.length; i++) {
            if (grades[i]) {
                puntaje += 20; 
            }
        }

        double nota = calcularNota(puntaje, 80);

        System.out.println("Puntaje obtenido: " + puntaje + '/' + 80);
        System.out.println("Nota: " + nota);


        System.out.println("Testeando actividad extra isPalindrome: ");

        if(nota == 7) {
            boolean[] extra_grades = new boolean[2]; 

            System.out.println("Iniciando evaluación de la función isPalindrome. \n");

            extra_grades[0] = test_isPalindrome_true();

            extra_grades[1] = test_isPalindrome_false();

            System.out.println("Evaluación terminada.");

            int puntaje_extra = 0;

            for (byte i = 0; i < extra_grades.length; i++) {
                if (extra_grades[i]) {
                    puntaje_extra += 50; 
                }
            }

            System.out.println("Puntaje obtenido: " + puntaje_extra + '/' + 100);
            System.out.println("Nota: " + calcularNota(puntaje_extra, 100));
        }
        
    }

    private static boolean test_insert() {
        try {
            DLL lista = new DLL();
            lista.insert(5);
            lista.insert(10);
    
            int expectedFirst = 10;
            int actualFirst = lista.head.val;
    
            int expectedSecond = 5;
            int actualSecond = lista.head.next.val;
    
            return ev("Test_InsertHead", actualFirst == expectedFirst && actualSecond == expectedSecond);
        } catch (Exception e) {
            System.out.println("[✘] Test_InsertHead falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_search_true() {
        try {
            DLL lista = new DLL();
            lista.insert(5);
            lista.insert(10);
            lista.insert(15);
    
            int expectedPos = 1;
            int actualPos = lista.search(10);
    
            return ev("Test_SearchVal", actualPos == expectedPos);
        } catch (Exception e) {
            System.out.println("[✘] Test_SearchVal falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_search_false() {
        try {
            DLL lista = new DLL();
            lista.insert(5);
            lista.insert(10);
            lista.insert(7);
            lista.insert(24);
            lista.insert(10);
            lista.insert(13);
    
            int expectedPos = -1;
            int actualPos = lista.search(17);
    
            return ev("Test_SearchVal", actualPos == expectedPos);
        } catch (Exception e) {
            System.out.println("[✘] Test_SearchVal falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

    private static boolean test_delete() {
        try {
            DLL lista = new DLL();
            lista.insert(5);
            lista.insert(10);
            lista.insert(15);
            lista.delete(10);
    
            int posAfterDelete = lista.search(10);
            System.out.println(posAfterDelete);

            return ev("Test_DeleteVal", posAfterDelete == -1);
        } catch (Exception e) {
            System.out.println("[✘] Test_DeleteVal falla por un error en el código.");
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


    private static boolean test_isPalindrome_true() {
        try {
            DLL lista = new DLL();
            lista.insert(5);
            lista.insert(10);
            lista.insert(15);
            lista.insert(10);
            lista.insert(5);

            boolean expected = true;
            boolean actual = lista.isPalindrome();
            return ev("Test_isPalindrome_true", actual == expected);
        } catch (Exception e) {
            System.out.println("[✘] Test_isPalindrome_true falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }


    private static boolean test_isPalindrome_false() {
        try {
            DLL lista = new DLL();
            lista.insert(5);
            lista.insert(8);
            lista.insert(15);
            lista.insert(7);
            lista.insert(5);

            boolean expected = false;
            boolean actual = lista.isPalindrome();
            return ev("Test_isPalindrome_true", actual == expected);
        } catch (Exception e) {
            System.out.println("[✘] Test_isPalindrome_true falla por un error en el código.");
            System.out.println("Error: " + e);
            return false;
        }
    }

}