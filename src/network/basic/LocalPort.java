package network.basic;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by fazhao on 16/9/12.
 */
public class LocalPort {
    public static void main(String args[]) {
//        int[] port = new int[1024];
        String host = "localhost";
        if (args.length > 0) {
            host = args[0];
        }
//        for (int i = 1; i < 1024; i++) {
//        for (int i = 1; i < 65535; i++) {
        /**
        * udp端口在unix系统下？  >1024 <65535
         * there is a server port for udp on 3283
         there is a server port for udp on 5353
         there is a server port for udp on 49332
         there is a server port for udp on 55443
         there is a server port for udp on 55609
         there is a server port for udp on 56993
         there is a server port for udp on 57393
         there is a server port for udp on 58075
         there is a server port for udp on 62758
         1024下的全部都会输出的
        * */
        for (int i = 1024; i < 65535; i++) {
            try {
//                System.out.println("finding port..." + i);
//                Socket s = new Socket(host, i);
//                ServerSocket s = new ServerSocket(i);

                /**
                * UDP port
                * */
                DatagramSocket socket = new DatagramSocket(i);
                socket.close();
//                port[i] = i;
                /**
                * other
                * */
//                System.out.println("there is a server on port" + i);
            }catch (SocketException e){
                /**
                * udp
                * */
                System.out.println("there is a server port for udp on " + i);
            }
//            catch (UnknownHostException e) {
//                System.out.println(e);
//                break;
//            }
            catch (IOException e) {
            }
        }
//        for (int i = 0; i < port.length; i++) {
//            if (port[i] != 0)
//                System.out.println(
//                        "There is a server on port " + port[i] + " of " + host);
//        }
    }
}