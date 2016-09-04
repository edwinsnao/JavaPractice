package network;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fazhao on 16/9/4.
 */
public class PicServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(10009);
            Socket s = ss.accept();
            InputStream in = s.getInputStream();
            FileOutputStream fos = new FileOutputStream("/Users/apple/Pictures/个人1.png");
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

            OutputStream out = s.getOutputStream();
            out.write("上传成功".getBytes());
            fos.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
