package network.basic;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * Created by fazhao on 16/9/18.
 */
public class DatagramSocketTest {
    public static final int PORT = 4000;
    public static final String NAME = "localhost";

    public static void main(String args[]) {
        String s = "hellohello";
        byte[] data = s.getBytes();
        try {
            InetAddress host = InetAddress.getByName(NAME);
//            DatagramSocket ds = new DatagramSocket(PORT, host);
//            DatagramSocket ds = new DatagramSocket();
            DatagramChannel channel = DatagramChannel.open();
            DatagramSocket ds = channel.socket();
            SocketAddress address = new InetSocketAddress(NAME,PORT);
            channel.configureBlocking(false);
            ds.setSoTimeout(15000);
            channel.connect(address);
//            ds.connect(host,PORT);
//            ds.setReceiveBufferSize(100);
//            ds.setSendBufferSize(100);
//            ds.bind(address);
            System.out.println(ds.getBroadcast());
            System.out.println(ds.getChannel());
            System.out.println(ds.getInetAddress());
            System.out.println(ds.getLocalAddress());
            System.out.println(ds.getLocalPort());
            System.out.println(ds.getLocalSocketAddress());
            System.out.println(ds.getTrafficClass());
            DatagramPacket out = new DatagramPacket(data,data.length);
            /**
            * .channels.IllegalBlockingModeException
             * 用selector？
            * */
//            ds.send(out);
            Selector selector = Selector.open();
            selector.select();
            Iterator keys = selector.selectedKeys().iterator();
            SelectionKey key = (SelectionKey) keys.next();
            keys.remove();
            DatagramChannel channel2 = (DatagramChannel) key.channel();
            channel2.configureBlocking(false);
            channel2.write((ByteBuffer) key.attachment());
//            channel.write(ByteBuffer.wrap(data));
            Iterator iterator = selector.selectedKeys().iterator();
//            while (iterator.hasNext()){
                DatagramChannel channel1 = (DatagramChannel) iterator.next();
            ByteBuffer buffer = ByteBuffer.allocateDirect(100);
            channel.configureBlocking(false);
                System.out.println("get:"+channel1.read(buffer));
//            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
