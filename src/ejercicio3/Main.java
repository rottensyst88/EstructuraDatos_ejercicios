package ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese cadena a procesar? ");
        String cadena = sc.nextLine();
        int z = Integer.parseInt(cadena);

        /*
        String[] cadenaArray = cadena.replaceAll(" ", "").split("");


        for(String x : cadenaArray) {
            System.out.println(x);
        }

        Pila p = new Pila(cadenaArray.length);

        try{
            for (String s : cadenaArray) {
                int resultado = 0;
                if(s.equals("+") || s.equals("-") || s.equals("*")) { //Es operacion
                    int a = p.Pop();
                    int b = p.Pop();

                    switch(s) {
                        case "+" -> resultado = a + b;
                        case "-" -> resultado = b - a;
                        case "*" -> resultado = a * b;
                    }
                    p.Push(resultado);
                }else{
                    int valor = Integer.parseInt(s);
                    p.Push(valor);
                }
            }

            System.out.println(""+p.Pop());
        } catch (Overflow e){
            System.out.println("Overflow!");
        } catch (Underflow e){
            System.out.println("Underflow!");
        }

         */
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int x = binarySearch(sortedArray, z);
        if (x == -1) {
            System.out.println("No existe el elemento");
        } else {
            System.out.println("El indice del elemento es: " + x);
        }


    }

    static int binarySearch(int[] array, int target) {
        int left = 0;                      // Índice inicial del rango de búsqueda
        int right = array.length - 1;      // Índice final del rango de búsqueda

        while (left <= right) {            // Mientras el rango sea válido
            int mid = left + (right - left) / 2;  // Calcular el punto medio (evita desbordamiento)

            if (array[mid] == target) {
                return mid;                // Elemento encontrado, retorna su índice
            } else if (array[mid] < target) {
                left = mid + 1;            // Descartar mitad izquierda
            } else {
                right = mid - 1;           // Descartar mitad derecha
            }
        }

        return -1;  // Si el elemento no está en el arreglo
    }
}
