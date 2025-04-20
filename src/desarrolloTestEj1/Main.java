package desarrolloTestEj1;

public class Main {
    public static void main(String[] args) {
        System.out.println(Ceros(0b01010100010101000101010001010100, (byte) 10));
    }

    public static byte Ceros(int x, byte p){
        int mask = 0x80000000;
        int i = 0;
        int cont = 0;

        while(i < p){
            if((x & mask) == mask){
                cont++;
            }
            mask = mask >>> 1;
            i++;
        }

        return (byte) (p - cont);
    }
}
