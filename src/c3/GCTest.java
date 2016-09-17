package c3;

/**
 * Created by Kings on 2016/4/24.
 */
public class GCTest {
    private static final int _1MB = 1024*1024;
    /*
    * String不分配空间   分在了常量池？
    * */
    static String str = "helllo";
    /*
    * 这里相当于常量，所以可以拼接为string，true
    * */
//    static final String str1 = "str";
//    static final String str2 = "ing";
    /*
    * 没有final修饰，不是常量，所以false
    * */
//    static String str1 = "str";
//    static String str2 = "ing";
     public static void main(String[] args){
         Integer a = 1;
         Integer b = 2;
         Integer c = 3;
         Integer d = 3;
         Integer e = 321;
         Integer f1 = 321;
         Integer f = 321;
         Long g = 3L;
         Boolean b1 = true;
         Boolean b2 = true;
         Boolean b3 = false;
         /*
         * 因为这里是局部变量，所以返回false
         * */
//         String str1 = "str";
//         String str2 = "ing";
          /*
         * 因为这里是final修饰的常量，所以返回true
         * */
         final String str1 = "str";
         final String str2 = "ing";

         String str3 = "str" + "ing";
         String str4 = str1 + str2;
         System.out.println(str4);
         System.out.println(str3);
         System.out.println(str3 == str4);//false

         String str5 = "string";
         System.out.println(str3 == str5);//true
         /*
         * true
false
true
true
false
true
         * */
         System.out.println(c==d);
         System.out.println(b1==b2);
         System.out.println(b1==b3);
         System.out.println(e==f1);
         System.out.println(c==(a+b));
         System.out.println(c.equals(a+b));
         System.out.println(g.equals(a+b));
         System.out.println(g==(a+b));

        int test = 1;
         int test1 = test;
         System.out.println(test+"  "+test1);
         test1 = 2;
         System.out.println(test+"  "+test1);

         String s = "Test";
         /*
         * true
         * true
         * true
         * */
//         String s1 = "Test";
         /*
         * false
         * true
         * true
         * */
         String s1 = new String("Test");
//         String s1 = "Test1";
         System.out.println(s==s1);    //内存地址不同
         System.out.println(s.equals(s1));
         System.out.println(s.intern() == s1.intern());


         Double dd = new Double(3.14);
         Float ff = new Float(3.1);
         float f10 = (int)3.14;
         double d10 = 3.14;
         System.out.println(f10);


         /*
         * PSYoungGen      total 36352K, used 5187K [0x00000000d0b00000, 0x00000000d3380000, 0x00000000f9000000)  多分配了2M
         * */
         byte[] allocation = new byte[2*1024*1024];
         /*-verbose:gc -XX:-UseCompressedOops -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
         * hello world
helllo
Heap
 PSYoungGen      total 9216K, used 7840K [0x0000000003800000, 0x0000000004200000, 0x0000000004200000)
  eden space 8192K, 95% used [0x0000000003800000,0x0000000003fa81b8,0x0000000004000000)
  from space 1024K, 0% used [0x0000000004100000,0x0000000004100000,0x0000000004200000)
  to   space 1024K, 0% used [0x0000000004000000,0x0000000004000000,0x0000000004100000)
  此时已经出现GC  ，移动到OldGen中
 ParOldGen       total 10240K, used 4096K [0x0000000002e00000, 0x0000000003800000, 0x0000000003800000)
  object space 10240K, 40% used [0x0000000002e00000,0x0000000003200018,0x0000000003800000)
 Metaspace       used 3106K, capacity 4108K, committed 4352K, reserved 8192K
         *
         * */
         byte[] allocation1 = new byte[2*1024*1024];
         /*
         * [GC (Allocation Failure) [PSYoungGen: 7676K->904K(9216K)] 7676K->7056K(19456K), 0.0035096 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (Ergonomics) [PSYoungGen: 904K->0K(9216K)] [ParOldGen: 6152K->6908K(10240K)] 7056K->6908K(19456K), [Metaspace: 3039K->3039K(8192K)], 0.0056242 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
FULL GC是STW stop-the-world要停止所有用户线程（停顿产生的原因）
GC是不会停顿
【】包住的是内存的使用情况   gc前-》gc后
【】外的是堆的使用情况  gc前-》gc后
hello world
helllo
Heap
 PSYoungGen      total 9216K, used 6467K [0x0000000003600000, 0x0000000004000000, 0x0000000004000000)
  eden space 8192K, 78% used [0x0000000003600000,0x0000000003c50c98,0x0000000003e00000)
  from space 1024K, 0% used [0x0000000003e00000,0x0000000003e00000,0x0000000003f00000)
  to   space 1024K, 0% used [0x0000000003f00000,0x0000000003f00000,0x0000000004000000)
 ParOldGen       total 10240K, used 6908K [0x0000000002c00000, 0x0000000003600000, 0x0000000003600000)
  object space 10240K, 67% used [0x0000000002c00000,0x00000000032bf398,0x0000000003600000)
 Metaspace       used 3096K, capacity 4108K, committed 4352K, reserved 8192K
         * */
         byte[] allocation5 = new byte[2*1024*1024];
         byte[] allocation2 = new byte[2*1024*1024];
         /*
         * 这里我不发生gc但是书中发生，可能是因为jdk8默认加了PretenureSizeThreShold为4M左右的大小直接进入老年区
         * 注意 -XX:PretenureSizeThreshold=1145728    1M       不可以直接写1M
         * */
         byte[] allocation3 = new byte[4*_1MB];
         /*
         * 发现打印log前后一样，是因为分配allocation4后超出heap大小所以就不分配忽略了它？
         * */
//         byte[] allocation4 = new byte[36*_1MB];
         /*
         * System.out.println();不会分配空间
         * */
          System.out.println("hello world");
          System.out.println(str);
         /*
         * hello world
Heap
 PSYoungGen      total 36352K, used 3139K [0x00000000d0b00000, 0x00000000d3380000, 0x00000000f9000000)
  eden space 31232K, 10% used [0x00000000d0b00000,0x00000000d0e10ec8,0x00000000d2980000)
  from space 5120K, 0% used [0x00000000d2e80000,0x00000000d2e80000,0x00000000d3380000)
  to   space 5120K, 0% used [0x00000000d2980000,0x00000000d2980000,0x00000000d2e80000)
  因为PSYoungGen中没有用完。所以不会GC并且不会移动到OldGen中
 ParOldGen       total 83456K, used 0K [0x0000000080000000, 0x0000000085180000, 0x00000000d0b00000)
  object space 83456K, 0% used [0x0000000080000000,0x0000000080000000,0x0000000085180000)
 Metaspace       used 3016K, capacity 4108K, committed 4352K, reserved 8192K


PSYoungGen   -->是Parallel Scavenge收集器
         * */
         }

}
