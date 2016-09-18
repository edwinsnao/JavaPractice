package network.basic.mutilcast;

/**
 * Created by fazhao on 16/9/18.
 */
import java.net.*;
import java.io.*;


/**
* 需要结合MulticastSniffer一起使用，先运行Sniffer再运行Sender
 * 并且配置相同all-systems.mcast.net 4000
* */
public class MulticastSender {

    public static void main(String[] args) {

        InetAddress ia = null;
//        int port = 9875;
        int port = 4000;
        byte ttl = (byte) 1;

        // read the address from the command line
        try {
//            ia = InetAddress.getByName(args[0]);
            /**
            * error:java.net.SocketException: Not a multicast address
             * */
//            ia = InetAddress.getByName("localhost");
//            ia = InetAddress.getByAddress("224.0.0.2".getBytes());
//            ia = InetAddress.getByName("localhost");
//            ia = InetAddress.getByName("224.0.0.1");
            ia = InetAddress.getByName("all-systems.mcast.net");
//            224.2.127.254
//            ia = InetAddress.getByName("sap.mcast.net");
//            port = Integer.parseInt(args[1]);
//            if (args.length > 2) ttl = (byte) Integer.parseInt(args[2]);
        }
        catch (Exception ex)  {
//            System.out.println("exit");
            System.err.println(ex);
            System.err.println(
                    "Usage: java MulticastSender multicast_address port ttl");
            System.exit(1);
        }

        byte[] data = "Here's some multicast data\r\n".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);

        try {
            MulticastSocket ms = new MulticastSocket();
            ms.joinGroup(ia);
            for (int i = 1; i < 10; i++) {
                ms.send(dp, ttl);
            }
            ms.leaveGroup(ia);
            ms.close();
//            System.out.println("close");
        }
        catch (SocketException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }

    }

}

