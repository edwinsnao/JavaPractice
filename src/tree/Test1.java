package tree;

/**
 * Created by Kings on 2016/4/4.
 */
public class Test1{
public class Node{   //节点类
    private char data;
    private Node lchild;
    private Node rchild;
    public Node(){

    }
    public Node(char data,Node lchild,Node rchild){
        this.data=data;
        this.lchild=lchild;
        this.rchild=rchild;
    }
    public void setlchild(Node lchild) {
        this.lchild = lchild;
    }
    public void setrchild(Node rchild) {
        this.rchild=rchild;

    }
    public Node getRchild() {
        // TODO Auto-generated method stub
        return rchild;
    }
    public Node getLchild() {
        // TODO Auto-generated method stub
        return lchild;
    }
    public char getData() {
        // TODO Auto-generated method stub
        return data;
    }

}
    public Node creatBinaryTree(String exp){
        char[] exps=exp.toCharArray();
        Node[] node=new Node[4];
        Node curr = null;
        int j=0,top=0,type=0;
        while(j<exps.length){
            switch(exps[j]){
                case '(':
                    /*
                    * node[n]只是一个指针指向一个又一个的结点
                    * 然后给每个结点赋值（赋值孩子）
                    * */
                    node[top]=curr;
                    type=1;
                    break;
                case ')':
                    top=top-1;
                    break;
                case ',':

                    top=top-1;
                    type=2;
                    break;
                default:
                    curr=new Node(exps[j],null,null);
                    switch(type){
                        case 1:
                            node[top].setlchild(curr);
                            top=top+1;
                            break;
                        case 2:
                            node[top].setrchild(curr);
                            top=top+1;
                            break;
                        default:
                            break;
                    }
            }
            j++;
        }
        return node[0];
    }
    public void PreOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.getData() + " ");
            PreOrder(node.getLchild());
            PreOrder(node.getRchild());

        }
    }
    public void LastOrder(Node node){
        if (node == null) {
            return;
        }
        else{
            LastOrder(node.getLchild());
            LastOrder(node.getRchild());
            System.out.print(node.getData() + " ");

        }
    }
    public void CneterOrder(Node node){
        if (node == null) {
            return;
        }
        else{
            CneterOrder(node.getLchild());
            System.out.print(node.getData() + " ");
            CneterOrder(node.getRchild());


        }
    }
    public static void main(String[] args) {
        Test1 tree=new Test1();
        System.out.println("PreOrder:");
//        tree.PreOrder(tree.creatBinaryTree("A(F,B(O,J))"));
        tree.PreOrder(tree.creatBinaryTree("A(F,B(O(Z,H),J))"));
        System.out.println("\nLastOrder:");
//        tree.LastOrder(tree.creatBinaryTree("A(F,B(O,J))"));
        tree.LastOrder(tree.creatBinaryTree("A(F,B(O(Z,H),J))"));
        System.out.println("\nCenterOrder:");
//        tree.CneterOrder(tree.creatBinaryTree("A(F,B(O,J))"));
        tree.CneterOrder(tree.creatBinaryTree("A(F,B(O(Z,H),J))"));

    }

}
