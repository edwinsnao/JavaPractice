package c11;

public class NoParentClassLoader extends ClassLoader {
    public NoParentClassLoader() {
        super(null);
    }
    
    public void testLoad() throws ClassNotFoundException {
        Class<?> clazz = loadClass("c11.ClassLoaderParent");
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        NoParentClassLoader loader = new NoParentClassLoader();
        System.out.println(NoParentClassLoader.class.getClassLoader());
        loader.testLoad();
    }
}
