package c3;

/**
 * Created by Kings on 2016/4/24.
 */

public class LoadTest {
    static int i = 2;
    static double d = 7.1;
 public static void main(String[] args){
/*
* supper
1
sub
1
9
* */
      System.out.println(sub.test);
     sub test = new sub();
//     System.out.println(test.test);
//     supper test1 = new supper();

//     System.out.println((int )(i+d));
     System.out.println(((i+(int)d)));
//     System.out.println(test1.test);
    /*
    * 没输出
    * */
     supper[] s = new supper[10];
     }
}
class supper {
    static {
        /*
        * wrong   illegal forward reference
        * */
//        System.out.println(test);
        System.out.println("supper");
    }

    {


    System.out.println(test);
}
    public static int test = 1;
}
class sub extends supper{
    static {
        System.out.println("sub");
    }
}