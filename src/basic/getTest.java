package basic;

/**
 * Created by fazhao on 16/9/22.
 */
public class getTest {
    public static void test(Val val){
        val.i = 20;
        int i = 99;
        another();
        System.out.println(val);
        System.out.println(val.i+" "+i);
    }
    public static void another(){
        Val val1 = new Val();
        Val val = val1;
        int i = 0;
        System.out.println(val);
        System.out.println(val.i+" "+ i);
    }
    /**
    * 等价于下面
    *
    * */
//    public static void another(int i,Val val){
//        Val val1 = new Val();
//        val = val1;
//        i = 0;
//        System.out.println(val);
//        System.out.println(val.i+" "+i);
//    }
    public static void main(String args[]){

        test(new Val());
        }
}
class Val{
    int i =10;
}
