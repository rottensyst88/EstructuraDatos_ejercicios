package ejercicioComplejidad;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un listado de valores? ");
        String x = sc.nextLine();

        String[] array = x.split("");
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = Integer.parseInt(array[i]);
        }

        if (esMayoria(sortedArray)) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    public static boolean esMayoria(int[] sortedArray){
        int valorCo= sortedArray.length/2;
        int cont = 0;

        for (int X : sortedArray) {
            cont = 0;

            for (int i : sortedArray) {
                if (X == i) {
                    cont++;
                }

                if (cont > valorCo) {
                    return true;
                }
            }
        }

        return false;
    }
}
