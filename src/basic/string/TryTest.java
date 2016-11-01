package basic.string;

/**
 * Created by fazhao on 2016/11/1.
 */
public class TryTest {
    public static void main(String args[]){
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
