package network;

/**
 * Created by fazhao on 16/9/3.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 定义端点接收数据打印出来
 * 服务端：
 * 1.建立服务端的socket服务，servicesocket,并监听一个端口
 * 2.获取连接过来的客户端对象，通过accept方法，这个方法是阻塞的，没有连接就会等
 * 3.客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取到该对象的读取流
 * 4.关闭服务端（可选操作）
 * @author LGL
 *
 */
public class TCPService {
    public static void main(String[] args) throws IOException {
        InputStream in = null;
        BufferedReader br = null;
        try {
            //1.建立连接，监听端口
            ServerSocket ss = new ServerSocket(10000);
            //2.连接客户端对象
            Socket accept = ss.accept();
            ConnectListener listener = new ConnectListener(accept);
            listener.start();
            //获取ip
            String ip = accept.getInetAddress().getHostAddress();
            String ip1 = accept.getInetAddress().getHostName();
            byte[] ip2 = accept.getInetAddress().getAddress();
            String ip3 = accept.getInetAddress().getCanonicalHostName();
            System.out.println(ip);
            System.out.println(ip1);
            System.out.println(ip2);
            System.out.println(ip3);
            //3.获取客户端发送过来的数据
            in = accept.getInputStream();
            //4.开始读取
            byte [] buf = new byte[1024];
            int len = in.read(buf);
            System.out.println(new String(buf,0,len));
//            br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
//            String s = null;
//            while((s = br.readLine())!=null)
//                System.out.println(s);
//            String s = br.readLine();
//            System.out.println(s);
            //5.关闭
//            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            in.close();
//            br.close();
        }
//        try{
//            ServerSocket ss = new ServerSocket(10000);
//            Socket accept = ss.accept();
//            String ip = accept.getInetAddress().getHostAddress();
//            InputStream in = accept.getInputStream();
//            byte[] buf = new byte[1024];
//            int len = in.read(buf);
//            System.out.println(new String(buf,0,len));
//            ss.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            ServerSocket ss = new ServerSocket(10000);
//            Socket accept = ss.accept();
//            InputStream in = accept.getInputStream();
//            String ip = accept.getInetAddress().getHostAddress();
//            byte[] buf = new byte[1024];
//            int len = in.read(buf);
//            System.out.println(new String(buf,0,len));
//            ss.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
