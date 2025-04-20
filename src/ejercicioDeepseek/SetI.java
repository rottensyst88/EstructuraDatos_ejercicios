package ejercicioDeepseek;

class SetI extends SetIBase {

    // Constructor
    public SetI() {
        super();
    }

    public SetI(int inicial) {
        super(inicial);
    }

    //------------------------------------------
    // EJERCICIOS A IMPLEMENTAR
    //------------------------------------------

    // 1. Cardinalidad (Ejemplo)
    public int cardinalidad() {
        return Integer.bitCount(conjunto);
    }

    // 2. Subconjunto (Ejemplo)
    public boolean subconjunto(SetI otro) {
        return (this.conjunto & otro.getConjunto()) == otro.getConjunto();
    }

    // 3. Unión
    public SetI union(SetI otro) {
        return new SetI(this.conjunto | otro.conjunto);
    }

    // 4. Intersección
    public SetI interseccion(SetI otro) {
        return new SetI(this.conjunto & otro.conjunto);
    }

    // 5. Diferencia (s1 - s2)
    public SetI diferencia(SetI otro) {
        return new SetI(this.conjunto & ~otro.conjunto);
    }

    // 6. Complemento
    public SetI complemento() {
        int mask = 0xFFFFFFFF;
        return new SetI(~this.conjunto & mask);
    }

    // 7. Contiene elemento
    public boolean contiene(int x) {
        int mask = 0x00000001;
        int i = 0;

        while (i < x){
            mask = mask << 1;
            i++;
        }

        //System.out.println("DEBUG: "+ Integer.toBinaryString(mask));
        return (this.conjunto & mask) == mask;
    }

    // 8. Agregar elemento
    public void agregar(int x) {
        int mask = 0x00000001;
        int i = 0;

        while (i < x){
            mask = mask << 1;
            i++;
        }

        this.conjunto = this.conjunto | mask;
    }

    // 9. Eliminar elemento
    public void eliminar(int x) {
        int mask = 0x00000001;
        int i = 0;

        while (i < x){
            mask = mask << 1;
            i++;
        }

        this.conjunto = this.conjunto ^ mask;
    }

    // 10. Convertir a String binario (Útil para debugging)
    public String aBinario() {
        return String.format("%32s", Integer.toBinaryString(conjunto))
                .replace(' ', '0');
    }
}
