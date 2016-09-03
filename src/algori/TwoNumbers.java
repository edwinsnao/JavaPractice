package algori;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fazhao on 16/9/3.
 */
public class TwoNumbers {
//    public ListNode addTwoNumbers() {
//        ListNode ll1 = new ListNode(0);
//        ListNode ll2 = new ListNode(0);
//        ListNode.createNode(ll1, Arrays.asList(256));
//        ListNode.createNode(ll2, Arrays.asList(463));
//        ListNode l1 = ll1.next;
//        ListNode l2 = ll2.next;
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1.next, q = l2.next, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = x + y + carry;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            System.out.println(p.val);
//            System.out.println(q.val);
//            if (p != null) {
//                p = p.next;
//            }
//            if (q != null) {
//                q = q.next;
//            }
//        }
//        if (carry > 0)
//            curr.next = new ListNode(carry);
//        return dummyHead.next;
//    }
    public  ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode r = new ListNode(0);
        ListNode h = r;
        ListNode beforeend = r;

        while(l1 !=null && l2 != null){
            r.val += l1.val + l2.val;

            r.next = new ListNode(r.val / 10);
            r.val %= 10;

            beforeend = r;
            r = r.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode rest;
        if (l1 == null) rest = l2; else rest = l1;

        while(rest != null){
            r.val += rest.val;

            r.next = new ListNode(r.val / 10);
            r.val %= 10;

            beforeend = r;
            r = r.next;
            rest = rest.next;
        }

        if(beforeend.next != null && beforeend.next.val == 0) beforeend.next = null;

        return h;
    }
//    public  ListNode addTwoNumbers(ListNode l1,ListNode l2){
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1,q = l2,curr = dummyHead;
//        int carry = 0;
//        while( p !=null || q !=null){
//            int x = (p!=null)?p.val:0;
//            int y = (q!=null)?q.val:0;
//            int sum = x + y + carry;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if(p!=null)
//                p = p.next;
//            if (q!=null)
//                q = q.next;
//        }
//        if(carry > 0)
//            curr.next = new ListNode(carry);
//        return dummyHead.next;
//    }

    public static void main(String args[]) {
        TwoNumbers main = new TwoNumbers();
//        ListNode node1 = new ListNode(243);
//        while(main.addTwoNumbers().next!=null)
        ListNode node = main.addTwoNumbers(new ListNode(234),new ListNode(563));
//        while(node!=null) {
//            System.out.println(node.val);
//            node.next = node.next.next;
//        }
        System.out.println(node);
//        main.addTwoNumbers(main.ListNode(243),main.ListNode(564));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public static void createNode(ListNode node, List<Integer> list) {
            node.next = new ListNode(list.get(0));
            /**
             *递归初始化
             * */
            if (list.size() > 1)
                createNode(node.next, list.subList(1, list.size()));
        }

        @Override
        public String toString() {
            if(next == null)
                return ""+val;
            else
                return "" + val+""+next;
        }
    }
}
