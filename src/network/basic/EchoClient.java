package network.basic;

import java.net.*;
import java.io.*;

public class EchoClient {

    public static void main(String[] args) {

        String hostname = "localhost";
//        String hostname = "www.baidu.com";

        if (args.length > 0) {
            hostname = args[0];
        }

        PrintWriter out = null;
        BufferedReader networkIn = null;
        try {
            Socket theSocket = new Socket(hostname, 88);
            networkIn = new BufferedReader(
                    new InputStreamReader(theSocket.getInputStream()));
            BufferedReader userIn = new BufferedReader(
                    new InputStreamReader(System.in));
            out = new PrintWriter(theSocket.getOutputStream());
            System.out.println("Connected to echo server");

            while (true) {
                String theLine = userIn.readLine();
                if (theLine.equals(".")) {
                    System.out.println(theLine);
                    break;
                }
                out.println(theLine);
                out.flush();
                System.out.println(theLine);
                /**
                 * 如果多次调用readLine的话，则打印最后一次的readLine，最后一次是null，所以就造成输出是null了
                 * 所以要定义theLine这个变量，以防止多次readLine
                 * */
//                System.out.println(networkIn.readLine());
            }

        }  // end try
        catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (networkIn != null) networkIn.close();
                if (out != null) out.close();
            } catch (IOException e) {
            }
        }

    }  // end main

}  // end EchoClient
