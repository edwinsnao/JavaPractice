package network.basic.mutilcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/18.
 */
public class MulticastPrac {
    public static final int PORT = 9875;
    public static final String NAME = "sap.mcast.net";
    public static void main(String args[]){
        InetAddress group = null;
        MulticastSocket ms = null;
        try {
            group = InetAddress.getByName(NAME);
            ms = new MulticastSocket(PORT);
            ms.joinGroup(group);

            byte[] buffer = new byte[8192];
            /**
            * write
            * */
            String msg = "Send Multicast";
            byte[] data = msg.getBytes();
            /**
             * 在没有后面指定ip地址还有端口号会报错
            *error:lang.NullPointerException: null buffer || null address
             * 发送必须要指定
            * */
//            DatagramPacket dp1 = new DatagramPacket(data,data.length);
            DatagramPacket dp1 = new DatagramPacket(data,data.length,group,PORT);
            ms.send(dp1);

            /**
            * read
             * 接受是任何发的都接受，所以可以忽略后面两个参数以接受任何主机发的
            * */
            while (true){
                DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
                ms.receive(dp);
                String s = new String(dp.getData());
                System.out.println(s);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ms != null){
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
