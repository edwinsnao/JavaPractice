package c3;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kings on 2016/4/25.
 */
public class ClassLoaderTest {
     public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//          ClassLoader loader = new ClassLoader(){
//              @Override
//              protected Class loadClass(String class_name, boolean resolve) throws ClassNotFoundException {
//                  try{
//                      String fileName = class_name.substring(class_name.indexOf(".")+1)+".class";
//                      InputStream is = getClass().getResourceAsStream(fileName);
//                      if(is == null){
//                          return super.loadClass(class_name);
//                      }
//                      byte[] b = new byte[is.available()];
//                      is.read(b);
//                      return defineClass(class_name,b,0,b.length);
//                  } catch (IOException e) {
//                      e.printStackTrace();
//                  }
////                  return super.loadClass(class_name, resolve);
//
//              }
//          } ;
//         Object obj = loader.loadClass("c3.GCTest").newInstance();
//         System.out.println(obj.getClass());
//         System.out.println(obj instanceof c3.GCTest);
//         }
         ClassLoader myLoader = new ClassLoader() {
             @Override
             public Class<?> loadClass(String name) throws ClassNotFoundException {
                 try {
                     String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                     InputStream is = getClass().getResourceAsStream(fileName);
                     if (is == null) {
                         return super.loadClass(name);
                     }
                     byte[] b = new byte[is.available()];
                     is.read(b);
                     return defineClass(name, b, 0, b.length);
                 } catch (IOException e) {
                     throw new ClassNotFoundException(name);
                 }
             }
         };

         Object obj = myLoader.loadClass("c3.GCTest").newInstance();
/*
*
* class c3.GCTest
false
true
* */
         System.out.println(obj.getClass());
         /*
         * 返回false是因为obj是我们自定义的类加载器
         * c3.GCTest是系统应用程序类加载器
         * */
         System.out.println(obj instanceof c3.GCTest);
         java.lang.ClassLoader loader = ClassLoaderTest.class.getClassLoader();
         Class<?>clazz = loader.loadClass("c3.GCTest");
         /*
         * 因为是用系统应用类加载器加载的
         * 所以是同一个   返回true
         * */
         java.lang.ClassLoader loader1 = java.lang.ClassLoader.getSystemClassLoader();
         System.out.println(clazz.newInstance() instanceof c3.GCTest);
     }
}
