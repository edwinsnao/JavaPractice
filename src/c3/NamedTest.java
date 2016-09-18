package c3;

/**
 * Created by Kings on 2016/8/15.
 */
public class NamedTest {
     static int test = 1;

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    class Test{
        public void test(){
            test = 1;
        }
    }

     public static void main(String[] args){
         System.out.println(String.valueOf(test));
     }
}
