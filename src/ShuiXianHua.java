public class ShuiXianHua{
    public int start,end;

    protected int test;

    int test1;

    /**
    * 自己可以赋值
    * */
    private int test2;

    ShuiXianHua(){

    }

    public static int[] input = new int[4];

    ShuiXianHua(int start, int end){
        judge(start,end);
    }

    public static void judge(int start, int end){
        boolean hasResult = false;
        for(int i = start ; i <= end ; i++){
            int a = i / 100;
            int b = i / 10 % 10;
            int c = i % 10;
            if(i == a * a * a + b * b * b + c * c * c){
                System.out.print(i + " ");
                hasResult = true;
            }
        }
        if(!hasResult)
            System.out.print("no");
        System.out.println("");
    }

    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        input[0] = sc.nextInt();
//        input[1] = sc.nextInt();
//        input[2] = sc.nextInt();
//        input[3] = sc.nextInt();
//        judge(input[0],input[1]);
//        judge(input[2],input[3]);
        ShuiXianHua main = new ShuiXianHua();
        main.start = 100;
        main.end = 120;
        main.test = 1;
        main.test1 = 1;
        main.test2 = 1;
        System.out.println(main.test);
        System.out.println(main.test1);
        System.out.println(main.test2);
        main.judge(main.start,main.end);
    }
}

class Test{
    public void test(){
        ShuiXianHua shuiXianHua = new ShuiXianHua();
        /**
        * 其他类报错
        * */
//        shuiXianHua.test2 = 1;
//        System.out.println(shuiXianHua.test2);
    }
}