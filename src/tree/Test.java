package tree;

/**
 * Created by Kings on 2016/4/4.
 */
public class Test {
    /*
    * 创建树
    * */
    public static Node createTree(String exp) {
        Node[] nodes = new Node[100];
        Node b, p = null;
        int top = -1, k = 0, j = 0;
        char[] exps = exp.toCharArray();
        char data = exps[j];
        b = null;
        while (j < exps.length - 1) {
            switch (data) {
                case '(':
                    top++;
                    nodes[top] = p;
                    k = 1;
                    break;
                case ')':
                    top--;
                    break;
                case ',':
                    k = 2;
                    break;
                default:
                    p = new Node(data, null, null);
                    if (b == null) {
                        b = p;
                    } else {
                        switch (k) {
                            case 1:
                                nodes[top].setLchild(p);
                                break;
                            case 2:
                                nodes[top].setRchild(p);
                                break;
                        }
                    }
            }
            j++;
            data = exps[j];
        }
        return b;
    }
    /**
     * pre order recursive
     *
     * @param node
     */
    public void PreOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.getData() + " ");
            PreOrder(node.getLchild());
            PreOrder(node.getRchild());

        }
    }

    /**
     * in order recursive
     *
     * @param node
     */
    public void InOrder(Node node) {
        if (node == null) {
            return;
        } else {
            InOrder(node.getLchild());
            System.out.print(node.getData() + " ");
            InOrder(node.getRchild());
        }
    }

    /**
     * post order recursive
     *
     * @param node
     */
    public void PostOrder(Node node) {
        if (node == null) {
            return;
        } else {
            PostOrder(node.getLchild());
            PostOrder(node.getRchild());
            System.out.print(node.getData() + " ");
        }
    }
    public static void main(String[] args){
        Node node = new Node();
        createTree("(abdc,.sad)");
    }
}
