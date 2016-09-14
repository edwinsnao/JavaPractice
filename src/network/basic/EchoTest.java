package network.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/14.
 */
public class EchoTest {
    public static void main(String args[]) {
        String hostName = "localhost";
        PrintWriter out = null;
        BufferedReader br = null;
        Socket socket = null;
        try {
            socket = new Socket(hostName, 88);
            /**
            * 不需要這行
            * */
//            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream());
            System.out.println("Connected to Server");

            while (true) {
                String s = br.readLine();
                if (s.equals("."))
                    break;
                out.print(s);
                out.flush();
                System.out.println(s);
                /**
                 * 如果多次调用readLine的话，则打印最后一次的readLine，最后一次是null，所以就造成输出是null了
                 * 所以要定义theLine这个变量，以防止多次readLine
                 * */
//                System.out.println(networkIn.readLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
