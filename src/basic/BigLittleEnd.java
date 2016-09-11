package basic;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by fazhao on 16/9/11.
 */
public class BigLittleEnd {
    public static void main(String[] args) {
        ByteBuffer buffer= ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.asIntBuffer().put(0x1234);
        System.out.println(buffer.array()[3]);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(buffer.array()[3]);
    }
}

