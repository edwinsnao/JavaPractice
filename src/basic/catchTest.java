package basic;

/**
 * Created by fazhao on 16/9/22.
 */
public class catchTest {
    public static void test(int i){

        /**
        * 3
         4
         2
         3
         finally是无论如何都执行的，包括return，只是return导致4不输出不执行
        * */
            try {
                if(i == 1)
                throw new Exception();
                /**
                * 这里的1永远不会执行的
                * */
//                System.out.println("1");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("2");
                return;
            }finally {
                System.out.println("3");
            }
            System.out.println("4");
        }
    public static void main(String args[]){
            test(0);
            test(1);
        }
}
