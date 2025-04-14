package lab4_ev;

public class SLL extends SLLBase {
     
     @Override
     public void insert(int val) {
         ListNode dato = new ListNode(val);

         // cabeza de la lista vacia (no existente)
         if(isEmpty()){
             head = dato;
             return;
         }

         // este puede pasar al inicio de la cabeza, para añadirlo al inicio.
         if(head.val > dato.val){
             dato.next = head;
             head = dato;
             return;
         }

         for(ListNode n = head; n != null; n = n.next) {
             // en este caso, el ulimo elemento sera siempre el mayor
             if(n.next == null){
                 n.next = dato;
                 return;
             }

             // en este caso, se guarda el valor intermedio.
             if(n.next.val > dato.val){
                 ListNode sig = n.next;
                 n.next = dato;
                 dato.next = sig;
                 return;
             }
         }
     }
}
