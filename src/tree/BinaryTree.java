package tree;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Created by fazhao on 16/9/1.
 */
public class BinaryTree extends AbstractCollection {
    private Object root;
    private BinaryTree left,right,parent;
    private  int size;

    public BinaryTree(){

    }

    public BinaryTree(Object root){
        this.root = root;
        size = 1;
    }

    public BinaryTree(Object root,BinaryTree left,BinaryTree right){
        this(root);
        if(left !=null){
            this.left = left;
            left.parent = this;
            size += left.size();
        }
        if(right !=null){
            this.right = right;
            right.parent = this;
            size += right.size();
        }
    }

    public boolean equals(Object object){
        if(!(object instanceof  BinaryTree))
            return false;
        BinaryTree tree = (BinaryTree) object;
        return (tree.root.equals(root)
        && tree.left.equals(left)
        && tree.right.equals(right)
        && tree.parent.equals(parent)
        && tree.size == size
        );
    }

    public int hashCode(){
        return root.hashCode() + left.hashCode() + right.hashCode() + size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private boolean rootDone;
            private Iterator lit,rit;

            @Override
            public boolean hasNext() {
                return !rootDone || lit != null &&lit.hasNext() || rit !=null && rit.hasNext();
            }

            @Override
            public Object next() {
                if(rootDone){
                    if( lit !=null && lit.hasNext())
                        return lit.next();
                    if(rit != null && rit.hasNext())
                        return rit.next();
                    return null;
                }
                if(left !=null) lit = left.iterator();
                if(right !=null) rit = right.iterator();
                rootDone = true;
                return  root;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }

    public static void main(String args[]){
        BinaryTree e = new BinaryTree("E");
        BinaryTree g = new BinaryTree("G");
        BinaryTree h = new BinaryTree("H");
        BinaryTree i = new BinaryTree("I");
        BinaryTree d = new BinaryTree("D",null,g);
        BinaryTree f = new BinaryTree("F",h,i);
        BinaryTree b = new BinaryTree("B",d,e);
        BinaryTree c = new BinaryTree("C",f,null);
        BinaryTree tree = new BinaryTree("A",b,c);
        System.out.println(tree);
        System.out.println(b.equals(c));
        System.out.println(tree.size);
        System.out.println(b.size);
        System.out.println(tree.contains("E"));
//        System.out.println(tree.hashCode());
        System.out.println(b.iterator().hasNext());
        }

}
