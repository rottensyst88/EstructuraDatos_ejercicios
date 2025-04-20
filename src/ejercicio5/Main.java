package ejercicio5;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese cadena a procesar? ");
        String cadena = sc.nextLine();

        String[] cadenaArray = cadena.replaceAll(" ", "").split("");


        Fila F = new Fila(cadenaArray.length);

        for (String s : cadenaArray) {
            if (s.equals("a")) {
                F.Insert(0);
            }else{
                F.Insert(1);
            }
        }

        int contadorA = 0;
        int contadorB = 0;

        while (!F.isEmpty()) {
            if(F.Delete() == 0){
                contadorA++;
            }else{
                if(contadorA != 0){
                    contadorB++;
                }
            }
        }

        if(contadorA == contadorB){
            System.out.println("VALIDO!");
        }else{
            System.out.println("INVALIDO!");
        }
    }
}
