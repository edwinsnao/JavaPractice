package network.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/12.
 */
public class MyAddress {
    public static void main(String args[]){
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
            System.out.println(address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
