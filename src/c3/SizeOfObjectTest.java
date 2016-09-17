package c3;

import java.io.File;

import static c3.SizeOfObject.fullSizeOf;
import static c3.SizeOfObject.sizeOf;

/**
 * Created by Kings on 2016/4/23.
 */
public class SizeOfObjectTest {
    /**
     * -XX:+UseCompressedOops: mark/4 + metedata/8 + 4 = 16
     * -XX:-UseCompressedOops: mark/8 + metedata/8 + 4 + padding/4 = 24
     */
    static class A {
        int a;
    }

    /**
     * -XX:+UseCompressedOops: mark/4 + metedata/8 + 4 + 4 + padding/4 = 24
     * -XX:-UseCompressedOops: mark/8 + metedata/8 + 4 + 4 = 24
     */
    static class B {
        int a;
        int b;
    }

    /**
     * -XX:+UseCompressedOops: mark/4 + metedata/8 + 4 + 4 + padding/4 = 24
     * -XX:-UseCompressedOops: mark/8 + metedata/8 + 8 + 4 + padding/4 = 32
     */
    static class B2 {
        int b2a;
        Integer b2b;
    }

    /**
     * 不考虑对象头：
     * 4 + 4 + 4 * 3 + 3 * sizeOf(B)
     */
    static class C extends A {
        int ba;
        B[] as = new B[3];

        C() {
            for (int i = 0; i < as.length; i++) {
                as[i] = new B();
            }
        }
    }

    static class D extends B {
        int da;
        Integer[] di = new Integer[3];
    }

    /**
     * 会算上A的实例字段
     */
    static class E extends A {
        int ea;
        int eb;
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(new File("./target/classes").getAbsolutePath());
        System.out.println("sizeOf(new Object())=" + sizeOf(new Object()));
        System.out.println("sizeOf(new A())=" + sizeOf(new A()));
        System.out.println("sizeOf(new B())=" + sizeOf(new B()));
        System.out.println("sizeOf(new B2())=" + sizeOf(new B2()));
        System.out.println("sizeOf(new B[3])=" + sizeOf(new B[3]));
        System.out.println("sizeOf(new C())=" + sizeOf(new C()));
        System.out.println("fullSizeOf(new C())=" + fullSizeOf(new C()));
        System.out.println("sizeOf(new D())=" + sizeOf(new D()));
        System.out.println("fullSizeOf(new D())=" + fullSizeOf(new D()));
        System.out.println("sizeOf(new int[3])=" + sizeOf(new int[3]));
        System.out.println("sizeOf(new Integer(1)=" + sizeOf(new Integer(1)));
        System.out.println("sizeOf(new Integer[0])=" + sizeOf(new Integer[0]));
        System.out.println("sizeOf(new Integer[1])=" + sizeOf(new Integer[1]));
        System.out.println("sizeOf(new Integer[2])=" + sizeOf(new Integer[2]));
        System.out.println("sizeOf(new Integer[3])=" + sizeOf(new Integer[3]));
        System.out.println("sizeOf(new Integer[4])=" + sizeOf(new Integer[4]));
        System.out.println("sizeOf(new A[3])=" + sizeOf(new A[3]));
        System.out.println("sizeOf(new E())=" + sizeOf(new E()));
        /*
        *
sizeOf(new Object())=16
sizeOf(new A())=16
sizeOf(new B())=24
sizeOf(new B2())=24
sizeOf(new B[3])=32
sizeOf(new C())=24
fullSizeOf(new C())=128
sizeOf(new D())=32
fullSizeOf(new D())=64
sizeOf(new int[3])=32
sizeOf(new Integer(1)=16
sizeOf(new Integer[0])=16
sizeOf(new Integer[1])=24
sizeOf(new Integer[2])=24
sizeOf(new Integer[3])=32
sizeOf(new Integer[4])=32
sizeOf(new A[3])=32
sizeOf(new E())=24
Heap
 PSYoungGen      total 36352K, used 3803K [0x00000000d0b00000, 0x00000000d3380000, 0x00000000f9000000)
  eden space 31232K, 12% used [0x00000000d0b00000,0x00000000d0eb6eb0,0x00000000d2980000)
  from space 5120K, 0% used [0x00000000d2e80000,0x00000000d2e80000,0x00000000d3380000)
  to   space 5120K, 0% used [0x00000000d2980000,0x00000000d2980000,0x00000000d2e80000)
 ParOldGen       total 83456K, used 0K [0x0000000080000000, 0x0000000085180000, 0x00000000d0b00000)
  object space 83456K, 0% used [0x0000000080000000,0x0000000080000000,0x0000000085180000)
 Metaspace       used 3224K, capacity 4176K, committed 4352K, reserved 8192K
        *
        * */
    }

}

