package network;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/4.
 */
public class FileClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("192.168.1.103", 10006);
            BufferedReader bufr = new BufferedReader(new FileReader("/Users/apple/demo.txt"));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            String line = null;
            while ((line = bufr.readLine()) != null) {
                pw.println(line);
            }
            pw.print("over");
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));
            String str = bufIn.readLine();
            System.out.println(str);

            bufr.close();
            s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
