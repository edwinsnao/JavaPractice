package network;

/**
 * Created by fazhao on 16/9/3.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    public static void main(String[] args) {
//        try {
//            //1.创建客户端的服务，传地址和端口
//            Socket s = new Socket("192.168.1.103",10000);
//            //2.为了发送数据，应该获得socket流中的输出流
//            OutputStream out = s.getOutputStream();
//            out.write("你好".getBytes());
//            out.write("hello".getBytes());
//            out.write("123".getBytes());
//            s.close();
//        } catch (UnknownHostException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        try{
            Socket s = new Socket("192.168.1.103",10000);
            OutputStream out = s.getOutputStream();
            out.write("hello".getBytes());
            out.write("123".getBytes());
            s.close();
            out.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
