package network;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/4.
 */
public class PicClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("192.168.1.103", 10009);
            FileInputStream fis = new FileInputStream("/Users/apple/Pictures/个人.png");
            OutputStream out = s.getOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            //告訴服务端数据写完
//            s.shutdownInput();
            InputStream in = s.getInputStream();
            byte[] bufn = new byte[1024];
            int num = in.read(bufn);
            System.out.println(new String(bufn, 0, num));
            fis.close();
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
