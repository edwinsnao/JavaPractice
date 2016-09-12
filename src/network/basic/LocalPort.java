package network.basic;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/12.
 */
public class LocalPort {
    public static void main(String args[]) {
        int[] port = new int[100];
        String host = "localhost";
        if (args.length > 0) {
            host = args[0];
        }
        for (int i = 1; i < 1024; i++) {
            try {
                System.out.println("finding port..." + i);
                Socket s = new Socket(host, i);
                port[i] = i;
            } catch (UnknownHostException e) {
                System.out.println(e);
                break;
            } catch (IOException e) {
            }
        }
        for (int i = 0; i < port.length; i++) {
            if (port[i] != 0)
                System.out.println(
                        "There is a server on port " + port[i] + " of " + host);
        }
    }
}