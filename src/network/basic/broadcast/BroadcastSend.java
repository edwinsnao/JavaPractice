package network.basic.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by fazhao on 16/9/19.
 */
public class BroadcastSend {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            InetAddress ip = InetAddress.getByName("255.255.255.255");
            DatagramSocket ds = new DatagramSocket();
            String str = "Goma God Like.";
            DatagramPacket dp = new DatagramPacket(str.getBytes(),str.getBytes().length, ip, 3001);
            ds.send(dp);
            ds.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// 创建用来发送数据报包的套接字
    }
}
