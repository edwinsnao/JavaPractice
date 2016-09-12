package network.basic;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/12.
 */
public class MyAddress {
    public static void main(String args[]){
        Socket s = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
//            InetAddress router = InetAddress.getByName("router");
//            InetAddress mail = InetAddress.getByName("mail");
            s = new Socket(address,23);
            String port = String.valueOf(s.getPort());
            String host = String.valueOf(s.getInetAddress());
            System.out.println("connected to"+host+":"+port);
            System.out.println(address);
//            System.out.println(router);
//            System.out.println(mail);
            System.out.println(address.getHostAddress());
            System.out.println(s.isClosed());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                s.close();
                System.out.println(s.isClosed());
            } catch (IOException e) {

            }
        }

    }
}
