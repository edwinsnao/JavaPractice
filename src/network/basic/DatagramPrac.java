package network.basic;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/18.
 */
public class DatagramPrac {
    public static final int PORT = 1;
    public static void main(String args[]){
        try {
            /**
            * www.baidu.com/14.215.177.37
             www.baidu.com/14.215.177.37:1
             [B@511d50c0
             13
             0
            * */
            String s = "DatagrameTest";
            byte[] data = s.getBytes();
            InetAddress ia = InetAddress.getByName("www.baidu.com");
            DatagramPacket dp = new DatagramPacket(data,data.length,ia,PORT);
            System.out.println(dp.getAddress());
            System.out.println(dp.getSocketAddress());
            System.out.println(dp.getData());
            System.out.println(dp.getLength());
            System.out.println(dp.getOffset());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        }
}
