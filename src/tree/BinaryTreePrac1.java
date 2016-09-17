package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Kings on 2016/4/4.
 */
public class BinaryTreePrac1 {
    public class Node{
        private char data;
        public Node lchild;
        public Node rchild;
        public Node(){

        }
        public Node(char data,Node lchild,Node rchild){
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public Node getLchild() {
            return lchild;
        }

        public void setLchild(Node lchild) {
            this.lchild = lchild;
        }

        public Node getRchild() {
            return rchild;
        }

        public void setRchild(Node rchild) {
            this.rchild = rchild;
        }
    }
    public Node createBinaryTree(String exp){
        char[] exps = exp.toCharArray();
        int j = 0,top = 0,type = 0;
        Node[] node = new Node[4];
        Node curr = null;
        while(j<exps.length){
            switch (exps[j]){
                case '(':
                    node[top] = curr;
                    type = 1;
                    break;
                case ')':
                    top = top-1;
                    break;
                case ',':
                    top--;
                    type = 2;
                    break;
                default:
                    curr = new Node(exps[j],null,null);
                    switch (type){
                        case 1:
                            node[top].setLchild(curr);
                            top++;
                            break;
                        case 2:
                            node[top].setRchild(curr);
                            top++;
                            break;
                        default:
                            break;
                    }
            }
            j++;
        }
        return node[0];
    }
    public static void preOrderNonrecur(Node rootnode){
        if(rootnode==null){
            return;
        }
        Node p = rootnode;
        Stack<Node> stack = new Stack<Node>();
        stack.push(p);
        while(stack.isEmpty()!=true){
            p = stack.pop();
            System.out.print(p.getData()+" ");
            /*
            * 先入后出，所以先让rchild入栈
            * */
            if(p.rchild != null ){
                stack.push(p.rchild);
            }
            if(p.lchild != null){
                stack.push(p.lchild);
            }
        }
    }

    public void PreOrder2(Node node){
        if(node == null){
            return;
        }
        else{
            System.out.print(node.getData()+" ");
            PreOrder2(node.getLchild());
            PreOrder2(node.getRchild());
        }
    }
    public static void postOrderNonrecur(Node rootnode){
        if(rootnode==null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node current = rootnode;
        while(current !=null || stack.isEmpty()!=true){
            //step 1
            while(current!=null){
                if(current.rchild!=null){
                    stack.push(current.rchild);
                }
                stack.push(current);
                current = current.lchild;
            }

            // step2 既然出栈了，该节点肯定没有左孩子。
            current = stack.pop();
            if(current.rchild!=null && !stack.isEmpty() && current.rchild == stack.peek())  {
                stack.pop(); //出栈右孩子
                stack.push(current);
                current = current.rchild;
            }
            else{
                System.out.print(current.getData()+" ");
                current = null;
            }
        }
    }

    public void LastOrder2(Node node){
        if(node == null){
            return;
        }
        else{
            LastOrder2(node.getLchild());
            LastOrder2(node.getRchild());
            System.out.print(node.getData()+" ");
        }
    }
    public static void inOrderNonrecur(Node rootnode){
        if(rootnode==null){
            return;
        }

        Node current = rootnode;
        Stack<Node> stack = new Stack<Node>();
        while(current != null||stack.isEmpty()!=true){
            while(current!=null){
                stack.push(current);
                current = current.lchild;
            }
            if(current==null){
                Node node = stack.pop();
                System.out.print(node.getData()+" ");
                current = node.rchild;
            }
        }
    }

    public int height(Node rootnode){
        if(rootnode==null){
            return -1;
        }
        else{
            return Math.max(height(rootnode.lchild),height(rootnode.rchild))+1;
        }
    }
    public List<List<Character>> levelOrder(Node rootnode) {
        List<List<Character>> resultlist = new ArrayList<List<Character>>();

        for(int level = 0; level<= height(rootnode);level++)
        {
            List<Character> list = new ArrayList<Character>();
            printGivenLevel(rootnode,level,list);
            resultlist.add(list);
        }
        return resultlist;

    }

    public void printGivenLevel(Node rootnode, int level, List<Character> list){
        if(rootnode==null){
            return ;
        }
        if(level == 0){
            list.add(rootnode.data);
//            System.out.print(rootnode.data+" ");
        }
        else{
            printGivenLevel(rootnode.lchild, level-1, list);
            printGivenLevel(rootnode.rchild, level-1, list);
        }
    }


    public static void LevelOrderNonRecur(Node rootnode){
        Node tempnode = rootnode;
        ArrayDeque<Node> queue=new ArrayDeque<Node>();

        if(rootnode==null){
            return;
        }
        queue.add(tempnode);
        while(queue.isEmpty()!=true){
            tempnode = queue.remove();
            System.out.print(tempnode.data+" ");
            if(tempnode.lchild!=null)
                queue.add(tempnode.lchild);
            if(tempnode.rchild!=null)
                queue.add(tempnode.rchild);
        }
//        while(queue.peek()!=null)
//            System.out.print(queue.poll()+" ");
    }



    public void InOrder2(Node node){
        if(node == null){
            return;
        }
        else{
            InOrder2(node.getLchild());
            System.out.print(node.getData()+" ");
            InOrder2(node.getRchild());
        }
    }
     public static void main(String[] args){
         List<List<Character>> list = new ArrayList<>();
          BinaryTreePrac1 tree = new BinaryTreePrac1();
         System.out.println("PreOrder:");
//        tree.PreOrder(tree.creatBinaryTree("A(F,B(O,J))"));
//         tree.PreOrder2(tree.createBinaryTree("A(F,B(O(Z,H),J))"));
         tree.preOrderNonrecur(tree.createBinaryTree("A(F,B(O(Z,H),J))"));
         System.out.println("\nLastOrder:");
//        tree.LastOrder(tree.creatBinaryTree("A(F,B(O,J))"));
         Node node = tree.createBinaryTree("A(F,B(O(Z,H),J))");
//         tree.postOrderNonrecur(tree.createBinaryTree("A(F,B(O(Z,H),J))"));
         tree.postOrderNonrecur(node);
         System.out.println("\nCenterOrder:");
//        tree.CneterOrder(tree.creatBinaryTree("A(F,B(O,J))"));
         tree.inOrderNonrecur(tree.createBinaryTree("A(F,B(O(Z,H),J))"));
         System.out.println("\nLevelOrder:");
//        tree.CneterOrder(tree.creatBinaryTree("A(F,B(O,J))"));
//         tree.printGivenLevel(tree.createBinaryTree("A(F,B(O(Z,H),J))"),tree.height(node),list);
         list = tree.levelOrder(node);
         for(int i = 0 ; i<list.size();i++){
             /*
             * 加上下面的语句，否则出现[]
             * */
             if(list.get(i).size()>=1)
                 for (int j = 0;j<list.get(i).size();j++)
                     System.out.print(list.get(i).get(j)+" ");
//             else
//                System.out.print(list.get(i)+" ");
         }
         System.out.println("\nLevelNon ");
         LevelOrderNonRecur(node);

         }
}
