package network.basic.mutilcast;

/**
 * Created by fazhao on 16/9/18.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MutilcastSniffer {

    public static void main(String[] args) {

        InetAddress group = null;
//        try {
//            group = InetAddress.getByName("sap.mcast.net");
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
        /**
        * 9875是收听MBONE节目的端口。
        * */
        int port = 9875;
//        try {
////            byte[] address = "192.168.1.255".getBytes();
////            byte[] test = "192".getBytes();
////            for (int i = 0; i < test.length; i++) {
////                System.out.println(test[i]);
////            }
////            System.out.println(address.length);
////            group = InetAddress.getByAddress("192.168.1.255".getBytes());
//            group = InetAddress.getByName("sap.mcast.net");
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }

        // read the address from the command line
        try {
            group = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);
        }  // end try
        catch (Exception ex) {
//             ArrayIndexOutOfBoundsException, NumberFormatException,
//             or UnknownHostException
            System.err.println(
                    "Usage: java MulticastSniffer multicast_address port");
            System.exit(1);
        }

        MulticastSocket ms = null;

        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);

            byte[] buffer = new byte[8192];
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);
                String s = new String(dp.getData());
                System.out.println(s);
            }
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
        finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                }
                catch (IOException ex) {}
            }
        }

    }

}

