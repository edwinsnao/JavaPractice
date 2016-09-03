package algori.linkedList;

/**
 * Created by fazhao on 16/9/3.
 */
public class removeNode {
    public ListNode removeNode() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        int n = 4;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while(first !=null){
            length++;
            first = first.next;
        }
        length -=n;
        first = dummy;
        while(length>0){
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
//    public ListNode removeNode(ListNode head , int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        int length = 0;
//        ListNode first = head;
//        while(first !=null){
//            length++;
//            first = first.next;
//        }
//        length -=n;
//        first = dummy;
//        while(length>0){
//            length--;
//            first = first.next;
//        }
//        first.next = first.next.next;
//        return dummy.next;
//    }

    public static void main(String args[]) {
        removeNode main = new removeNode();
        while(main.removeNode().next!=null) {
            System.out.println(main.removeNode().val);
            main.removeNode().next = main.removeNode().next.next;
        }
    }

    class ListNode {
        private int val;
        private ListNode next;
            public ListNode(int x){
                val = x;
            }
    }
}
