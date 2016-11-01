package basic.string;

/**
 * Created by fazhao on 2016/11/1.
 */
public class TryTest {
    public static void main(String args[]){
        try {
            /**
            * 需要加上包名
            * */
            Class class1 = Class.forName("basic.string.TryTest");
            /**
            * cannot be cast to java.lang.Class
            * */
            Class class2 = (Class) class1.newInstance();
            System.out.println(""+class1.getName());
            System.out.println(""+class2.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /**
        * 可以不catch，直接finally
        * */
        try{
            System.out.println("1");
        }finally {
            System.out.println("haha");
        }
        }
}
