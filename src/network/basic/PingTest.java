package network.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/14.
 */
public class PingTest {

    /**
     * @param host
     */
    public static void ping(String host) {
        String line = null;
        try {
            Process pro = Runtime.getRuntime().exec("ping " + host);
            BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param host
     */
    public static void icmp(String host) {
        try {
            int timeOut = 3000;
            boolean status = InetAddress.getByName(host).isReachable(timeOut);
            System.out.println("发送数据包： " + status);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ping("127.0.0.1");
//        icmp("127.0.0.1");
    }

}
