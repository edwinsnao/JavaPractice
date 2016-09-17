package c11;


/*
* sun.misc.Launcher$AppClassLoader@75b84c92
sun.misc.Launcher$ExtClassLoader@1540e19d
* */
public class ClassLoaderParent {
    
    public void displayParents() {
        ClassLoader current = getClass().getClassLoader();
        while (current != null) {
            System.out.println(current.toString());
            current = current.getParent();
        }
    }

    public static void main(String[] args) {
        ClassLoaderParent clp = new ClassLoaderParent();
        clp.displayParents();
    }

}
