package basic;

/**
 * Created by fazhao on 16/9/22.
 */
public class getTest1 {
    static String s = "1";
    static String[] s1 = {"2"};
    static int x = 1;
    static int y = 2;

    public static void swap(int x,int y){
//        x = x+y;
//        y = x-y;
//        x = x-y;
        int tmp = x;
        x = y;
        y = tmp;
    }

    public static void changed(String[] s1){
        String s = new String("3");
        s1[0]= new String("4");
    }
    /**
    * 等价于
    * */
//    public static void changed(String s,String[] s1){
//        s= new String("3");
//        s1[0]= new String("4");
//    }
    public static void main(String args[]){
        changed(s1);
        System.out.println(s+" "+s1[0]);
        swap(x,y);
        System.out.println(x+" "+y);
        }
}
