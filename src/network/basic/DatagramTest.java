package network.basic;

import java.net.*;
import java.util.Scanner;

/**
 * Created by fazhao on 16/9/9.
 */
public class DatagramTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        Pattern p = Pattern.compile(input);
        String[] tmp = input.split(" ");
        int num = Integer.valueOf(tmp[0]);
        int num1 = Integer.valueOf(tmp[1]);
        System.out.println(num);
        System.out.println(num1);
        try (DatagramSocket ds = new DatagramSocket()) {
//            ds.connect();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        String s = "This is a test.";

        byte[] data = s.getBytes();
        try {
//            InetAddress ia = InetAddress.getByName("www.ibiblio.org");
            InetAddress ia = InetAddress.getByName("www.baidu.com");
            int port = 7;
            DatagramPacket dp
                    = new DatagramPacket(data, data.length, ia, port);
            System.out.println("This packet is addressed to "
                    + dp.getAddress() + " on port " + dp.getPort());
            System.out.println("There are " + dp.getLength()
                    + " bytes of data in the packet");
            System.out.println(
                    new String(dp.getData(), dp.getOffset(), dp.getLength()));
        }
        catch (UnknownHostException e) {
            System.err.println(e);
        }

    }

}
