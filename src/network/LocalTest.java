package network;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * Created by fazhao on 16/9/4.
 */
public class LocalTest {
    public static void main(String[] args) {
        try {
            ServerSocket socket1 = new ServerSocket();
            ServerSocket socket2 = new ServerSocket();
            socket1.setReuseAddress(true);
            socket1.bind(new InetSocketAddress("127.0.0.1", 8899));
            System.out.println("socket1.getReuseAddress():"
                    + socket1.getReuseAddress());
            /**
            * java.net.BindException: Address already in use
            * */
//            socket2.setReuseAddress(true);
//            socket2.bind(new InetSocketAddress("127.0.0.1", 8899));
//            System.out.println("socket2.getReuseAddress():"
//                    + socket1.getReuseAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
