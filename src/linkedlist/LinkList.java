package linkedlist;

/**
 * Created by fazhao on 16/9/28.
 */
public class LinkList {
    class Node1{
        int data;
        Node1 next;
        public Node1(int data){
            this.data = data;
        }
    }
    public Node1 head;
    public Node1 current;
    public void add(int data){
        if(head ==null){
            head = new Node1(data);
            current = head;
        }else{
            current.next = new Node1(data);
            current = current.next;
        }
    }
    public void print(Node1 node){
        int i = 0;
        if(node == null)
            return;
        current = node;
        System.out.print("[");
        while (current!=null){
            System.out.print(current.data+",");
            current = current.next;
            if(i++ > 30)
                break;
        }
        System.out.println("]");
    }

    public int getLength(Node1 head){
        if(head == null)
            return 0;
        int length = 0;
        Node1 current = head;
        while (current!=null){
            length++;
            current = current.next;
        }
        return length;
    }

    public Node1 getHead(){
        return head;
    }

    public int findLastKNode(int k){
        int size = 0;
        if(head == null)
            return  -1;
        current = head;
        while(current!=null){
            size++;
            current = current.next;
        }
        current = head;
        for (int i = 0; i < size - k; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
    * findLastKNode改进，不用遍历长度
     * 开辟另一个新的节点来完成，second来记录倒数第几个
     * 然后借它间接移动链表的长度
     * 假设10的长度，找倒数第一个
     * 所以first在第一个，second在第二个
     * 然后first和second一起移动，直到second移到末端
    * */
    public int findLastKNode1(Node1 head,int k){
        if(head == null || k == 0)
            return -1;
        Node1 first = head;
        Node1 second = head;
        for (int i = 0; i < k; i++) {
            second = second.next;
        }
        while(second!=null){
            first = first.next;
            second = second.next;
        }
        return first.data;
    }

    /**
    * 找中间：不允许遍历得到长度
     * 类似上面
     * 也是设置两个指针first和second，只不过这里是，两个指针同时向前走
     * ，second指针每次走两步，first指针每次走一步，直到second指针走到最后一个结点时
     * ，此时first指针所指的结点就是中间结点
    * */
    public int findMid(Node1 head){
        if(head == null)
            return -1;
        Node1 first = head;
        Node1 second = head;
        while(second!=null && second.next!=null){
            first = first.next;
            second = second.next.next;
        }
        return first.data;
    }

    private Node1 mergeSortList(Node1 head, Node1 head1) {
        if(head == null && head1 == null){
            try {
                throw new Exception("Invalid Input");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
        if(head == null){
            System.out.println("here");
            return head1;
        }
        if(head1 == null){
            System.out.println("here");
            return head;
        }
        Node1 node = head;
        Node1 node1 = head1;
        Node1 mergeHead = null;
        //ListNode node2 = mergeHead;
        if(node.data < node1.data){
            mergeHead = node;
            mergeHead.next = mergeSortList(node.next,node1);
        }else{
            mergeHead = node1;
            mergeHead.next = mergeSortList(node,node1.next);
        }
        return mergeHead;
    }

    public Node1 merge(Node1 head1,Node1 head2){
        if(head1 == null && head2 ==null)
            return null;
        if(head2 == null)
            return head1;
        if(head1 == null)
            return head2;
        int i = 0;
        Node1 first = head1;
//        Node1 result = first;
        Node1 second = head2;
        Node1 head3;
        if(first.data < second.data){
            head3 = first;
            head3.next = merge(first.next,second);
        }else{
            head3 = second;
            head3.next = merge(first,second.next);
        }
        return head3;
    }

    public Node1 mergeLinkList(Node1 head1, Node1 head2) {

        if (head1 == null && head2 == null) { //如果两个链表都为空
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node1 head; //新链表的头结点
        Node1 current; //current结点指向新链表
// 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
        if (head1.data < head2.data) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1; //新链表中，current指针的下一个结点对应较小的那个数据
                current = current.next; //current指针下移
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }

        //合并剩余的元素
        if (head1 != null) { //说明链表2遍历完了，是空的
            current.next = head1;
        }

        if (head2 != null) { //说明链表1遍历完了，是空的
            current.next = head2;
        }

        return head;
    }
//    public Node1 merge(Node1 head1,Node1 head2){
//        if(head1 == null && head2 ==null)
//            return null;
//        if(head2 == null)
//            return head1;
//        if(head1 == null)
//            return head2;
//        int i = 0;
////        Node1 first = head1;
////        Node1 result = first;
////        Node1 second = head2;
//        Node1 head3;
//        Node1 current1;
//        if(head1.data < head2.data){
//            head3 = head1;
//            current1 = head1;
//            head1 = head1.next;
//        }else{
//            head3 = head2;
//            current1 = head2;
//            head2 = head2.next;
//        }
//        while(head1 != null && head2 !=null){
//            if(head1.data < head2.data){
////                current = head1;
////                current = current.next;
//                current1.next = head1;
//                current1 = current1.next;
//                head1 = head1.next;
//            }else{
////                current = head2;
////                current = current.next;
//                current1.next = head2;
//                current1 = current1.next;
//                head2 = head2.next;
//            }
//        }
//        if(head1 != null)
////            while (head1 !=null) {
//            current1.next = head1;
//////                head1 = head1.next;
////        }
//        if(head2 != null)
////            while (head2!=null) {
//            current1.next = head2;
//////                head2 = head2.next;
////        }
//        return head3;
//    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        LinkList list1 = new LinkList();
//向LinkList中添加数据
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 10; i < 20; i++) {
            list1.add(i);
        }
        System.out.println("Length:"+list.getLength(list.getHead()));
        list.print(list.head);// 从head节点开始遍历输出
        System.out.println(list.findLastKNode(1));
        System.out.println(list.findLastKNode1(list.getHead(),1));
        System.out.println(list.findMid(list.getHead()));
        LinkList list2 = new LinkList();
        list2.head = list2.merge(list1.getHead(),list2.getHead());
//        list2.head = list2.merge(list1.head,list2.head);
        System.out.println(list2.getLength(list2.head));
//        list2.print(list2.head);
//        list2.print(list2.mergeSortList(list1.getHead(),list2.getHead()));
//        list2.print(list2.merge(list1.getHead(),list2.getHead()));
//        list2.head = list2.mergeSortList(list1.getHead(),list2.getHead());
        list2.head = list2.mergeLinkList(list1.getHead(),list2.getHead());
        list2.print(list2.head);
    }
}


