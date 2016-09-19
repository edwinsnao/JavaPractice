package io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by fazhao on 16/9/19.
 */
public class ByteBufferTest {
    public static void main(String args[]) {
//        ByteBuffer buffer = ByteBuffer.allocate(12);
        ByteBuffer buffer = ByteBuffer.allocateDirect(12);
        /**
        * 初始是0
        * */
        System.out.println(buffer.position());
        /**
        * 4字節
        * */
        buffer.putInt(100);
        System.out.println(buffer.position());
        /**
         * 8字節
         * */
        buffer.putLong(120L);
        System.out.println(buffer.position());
        /**
        * 重置為0
        * */
        buffer.rewind();
        for (int i = 0; i < 12; i++) {
            System.out.println("i: "+buffer.get(i));
        }
        System.out.println(buffer.position());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        /**
        * 讀取完又來到末尾12
        * */
        System.out.println(buffer.position());
        buffer.rewind();
        Path path = Paths.get("/Users/apple/test1");
        /**
        * SeekableByteChannel的操作類似于ByteBuffer
        * */
        try(SeekableByteChannel byteChannel = Files.newByteChannel(path, StandardOpenOption.CREATE
        ,StandardOpenOption.READ,StandardOpenOption.WRITE)){
            System.out.println(byteChannel.position());
            byteChannel.write(buffer);
            System.out.println(byteChannel.position());

//            ByteBuffer buffer1 = ByteBuffer.allocate(100);
            ByteBuffer buffer1 = ByteBuffer.allocateDirect(100);
            /**
            * 類似于rewind
            * */
            byteChannel.position(0);
            System.out.println(buffer1.position());
            buffer1.rewind();
            System.out.println(buffer1.position());
            byteChannel.read(buffer1);
            System.out.println(buffer1.position());
            System.out.println(byteChannel.position());
            buffer1.rewind();
            System.out.println(buffer1.getInt());
            System.out.println(buffer1.getLong());
            System.out.println(buffer1.getChar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
