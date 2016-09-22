package tree;

/**
 * Created by fazhao on 16/9/22.
 */
public class TreeTest1 {

    public static int getDepth(TreeNode root){
        if(root == null)
            return 0;
        else{
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            return 1+ Math.max(left,right);
        }
    }

    public static void main(String args[]){

        }
}
class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode(char val){
        this.val = val;
    }
}