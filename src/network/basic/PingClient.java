package network.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by fazhao on 16/9/14.
 */
public class PingClient {
    public static void ping(String host){
        String line = null;
        try{
            Process pro = Runtime.getRuntime().exec("ping "+host);
            BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            while((line = buf.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        ping("127.0.0.1");
//        ping("192.168.1.1");
//        ping("192.168.168.1");

        }
}
