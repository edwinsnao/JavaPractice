package tree;

/**
 * Created by fazhao on 16/9/27.
 */
public class SearchBinary {
    class node{
        node left;
        node right;
        int value;

    }
    /**
    * 查找第三大的
    * */
    public int search(node root) {
        int i = 0;
        node tmp = root;
        //获得了最大的节点
        if (tmp.right != null) {
            while (tmp.right != null) {
                tmp = tmp.right;
                i++;
            }
            tmp = root;
//            只有一个右节点
            if (i != 1)
//        获得最大节点的父节点
                for (int j = 0; j < i - 1; j++) {
                    tmp = tmp.right;
                }
            if (tmp.left != null)
                return tmp.left.value;
            else {
                tmp = root;
                for (int j = 0; j < i - 2; j++) {
                    tmp = tmp.right;
                }
                return tmp.value;
            }


        } else {
            tmp = tmp.left;
            while (tmp.right != null) {
                tmp = tmp.right;
                i++;
            }
            tmp = root.left;
            for (int j = 0; j < i - 1; j++) {
                tmp = tmp.right;
            }
            return tmp.value;
        }




    }
    public static void main(String args[]){

        }
}
