package tree;

/**
 * Created by Kings on 2016/4/4.
 */
public class BinaryTreePrac {
    public class Node{
        public Node lchild;
        public Node rchild;
        private char data;
        public Node(){

        }
        public Node(char data,Node lchild,Node rchild){
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
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

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }
    }
     public Node createBinaryTree(String exp){
         char[] exps = exp.toCharArray();
         Node[] node = new Node[4];
         Node curr = null;
         /*
         * curr是当前的结点
         * top是树的层数（深度，默认0）
         * */
         int j = 0,top = 0,type = 0;
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
                     top = top-1;
                     type = 2;
                     break;
                 default:
                     curr = new Node(exps[j],null,null);
                     switch (type){
                         case 1:
                             node[top].setLchild(curr);
                             top = top+1;
                             break;
                         case 2:
                             node[top].setRchild(curr);
                             top = top+1;
                             break;
                         default:
                             break;
                     }
             }
             j++;
         }
         return node[0];
     }
    public void PreOrder1(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.getData() + " ");
            PreOrder1(node.getLchild());
            PreOrder1(node.getRchild());
        }
    }
    public void LastOrder1(Node node) {
        if (node == null) {
            return;
//            break;
        } else {
            LastOrder1(node.getLchild());
            LastOrder1(node.getRchild());
            System.out.print(node.getData() + " ");
        }
    }
    public void InOrder(Node node){
        if(node ==null){
            return;
        }else{
            InOrder(node.getLchild());
            System.out.print(node.getData() + " ");
            InOrder(node.getRchild());
        }

    }
     public static void main(String[] args){
         BinaryTreePrac tree=new BinaryTreePrac();
         System.out.println("PreOrder:");
//        tree.PreOrder(tree.creatBinaryTree("A(F,B(O,J))"));
         tree.PreOrder1(tree.createBinaryTree("A(F,B(O(Z,H),J))"));
         System.out.println("\nLastOrder:");
//        tree.LastOrder(tree.creatBinaryTree("A(F,B(O,J))"));
         tree.LastOrder1(tree.createBinaryTree("A(F,B(O(Z,H),J))"));
         System.out.println("\nCenterOrder:");
//        tree.CneterOrder(tree.creatBinaryTree("A(F,B(O,J))"));
         tree.InOrder(tree.createBinaryTree("A(F,B(O(Z,H),J))"));
         }

}
