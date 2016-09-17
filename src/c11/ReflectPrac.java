package c11;

import java.lang.reflect.Method;

/**
 * Created by Kings on 2016/4/12.
 */

/*
Integer int
String class java.lang.String
Class class c11.ReflectPrac
Class class c11.ReflectPrac
Class class c11.ReflectPrac
ClassLoader sun.misc.Launcher$AppClassLoader@75b84c92
ClassLoader Classclass sun.misc.Launcher$AppClassLoader
ClassLoader sun.misc.Launcher$AppClassLoader@75b84c92
ClassLoader sun.misc.Launcher$AppClassLoader@75b84c92

Process finished with exit code 0
*
* */
public class ReflectPrac extends ClassLoader{
    public ReflectPrac(){
        super(null);
    }
    public void test() throws ClassNotFoundException {
        Class<?> clazz3 = loadClass("c11.ReflectPrac");
        Class<?> clazz1 = loadClass("c11.ClassLoaderParent");
        System.out.println("Class in test "+clazz3);
        System.out.println("Class in test"+clazz1);
    }
     public static void main(String[] args) throws ClassNotFoundException {
         ReflectPrac test = new ReflectPrac();
         Class<?> clazz = test.getClass();
         ClassLoader loader = test.getClass().getClassLoader();
         Class<?> loader_clazz = loader.getClass();
         Class<?> clazz1 = loader.loadClass("c11.ReflectPrac");
         Class<?> clazz2 = Class.forName("c11.ReflectPrac");
//         Class<?> clazz3 = loadClass("c11.ReflectPrac");
//         Class<?> clazz1 = loadClass("c11.ClassLoaderParent");

//         Method
         /*
         * Method:public static void c11.ReflectPrac.main(java.lang.String[]) throws java.lang.ClassNotFoundException
Method:public void c11.ReflectPrac.test() throws java.lang.ClassNotFoundException
Method:public java.lang.Class java.lang.ClassLoader.loadClass(java.lang.String) throws java.lang.ClassNotFoundException
Method:public static java.lang.ClassLoader java.lang.ClassLoader.getSystemClassLoader()
Method:public java.net.URL java.lang.ClassLoader.getResource(java.lang.String)
Method:public java.io.InputStream java.lang.ClassLoader.getResourceAsStream(java.lang.String)
Method:public static java.net.URL java.lang.ClassLoader.getSystemResource(java.lang.String)
Method:public static java.io.InputStream java.lang.ClassLoader.getSystemResourceAsStream(java.lang.String)
Method:public void java.lang.ClassLoader.clearAssertionStatus()
Method:public final java.lang.ClassLoader java.lang.ClassLoader.getParent()
Method:public java.util.Enumeration java.lang.ClassLoader.getResources(java.lang.String) throws java.io.IOException
Method:public static java.util.Enumeration java.lang.ClassLoader.getSystemResources(java.lang.String) throws java.io.IOException
Method:public void java.lang.ClassLoader.setClassAssertionStatus(java.lang.String,boolean)
Method:public void java.lang.ClassLoader.setDefaultAssertionStatus(boolean)
Method:public void java.lang.ClassLoader.setPackageAssertionStatus(java.lang.String,boolean)
Method:public final void java.lang.Object.wait() throws java.lang.InterruptedException
Method:public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
Method:public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
Method:public boolean java.lang.Object.equals(java.lang.Object)
Method:public java.lang.String java.lang.Object.toString()
Method:public native int java.lang.Object.hashCode()
Method:public final native java.lang.Class java.lang.Object.getClass()
Method:public final native void java.lang.Object.notify()
Method:public final native void java.lang.Object.notifyAll()
         * */
         Method[] methods =clazz.getMethods();
         for(int i = 0;i<methods.length;i++){
             System.out.println("Method:"+methods[i]);
         }

          System.out.println("Integer "+Integer.TYPE);
          System.out.println("String "+String.class);
          System.out.println("Class "+clazz);
          System.out.println("Class "+clazz1);
          System.out.println("Class "+clazz2);
          System.out.println("ClassLoader "+test.getClass().getClassLoader());
          System.out.println("ClassLoader Class"+test.getClass().getClassLoader().getClass());

         while(loader!=null){
             System.out.println("ClassLoader "+test.getClass().getClassLoader());
             loader = loader.getParent();
         }

//         test.test();
         }
}
