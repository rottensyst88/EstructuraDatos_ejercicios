package ejercicioDeepseek;

public class Evaluador {
    public static void main(String[] args) {
        // Test Unión
        SetI s1 = new SetI(34546);
        SetI s2 = new SetI(76463);

        System.out.println(s1.aBinario());
        System.out.println(s2.aBinario());

        // Test Cardinalidad
        System.out.println("Cardinalidad de s1: " + s1.cardinalidad()); // Debería ser 3// Test Subconjunto
        System.out.println("s2 es subconjunto de s1: " + s1.subconjunto(s2)); // Debería ser false// Test Unión

        SetI union = s1.union(s2);
        System.out.println("Unión: " + union.aBinario()); // Debería ser 00110101// Test Intersección

        SetI interseccion = s1.interseccion(s2);
        System.out.println("Intersección: " + interseccion.aBinario()); // Debería ser 00000001// Test Diferencia

        SetI diferencia = s1.diferencia(s2);
        System.out.println("Diferencia (s1 - s2): " + diferencia.aBinario()); // Debería ser 00100100// Test Complemento

        SetI complemento = s1.complemento();
        System.out.println("Complemento de s1: " + complemento.aBinario()); // Dependerá de la implementación// Test Contiene elemento

        System.out.println("s1 contiene el elemento 3: " + s1.contiene(3)); // Debería ser true
        System.out.println("s1 contiene el elemento 4: " + s1.contiene(4)); // Debería ser false// Test Agregar elemento

        s1.agregar(3);
        System.out.println("s1 después de agregar 3: " + s1.aBinario()); // Debería ser 00101101// Test Eliminar elemento

        s1.eliminar(1);
        System.out.println("s1 después de eliminar 1: " + s1.aBinario()); // Debería ser 00100100// Test Convertir a String binario

        System.out.println("s1 en binario: " + s1.aBinario()); // Debería ser 00100101
    }
}
