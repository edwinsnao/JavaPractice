package network;

/**
 * Created by fazhao on 16/9/4.
 */
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ConnectListener extends Thread
{
    //定义一个Client的对象
//    private Client client;

    private Socket socket;
    //定义IP和端口号是常量
    private static final String IP = "192.168.1.103";

    private static final int PORT = 10000;
//    private static final int PORT = 20108;
    //声明str是一个静态变量，
    public static StringBuilder str = new StringBuilder();
    //进行构造（持有另一个类对象的引用）
//    public ConnectListener(Client client)
//    {
//        this.client = client;
//    }
    public ConnectListener(Socket socket)
    {
        this.socket = socket;
    }
    //启用线程，处理连接
    public void run()
    {
//        try
//        {
            //初始化要连接的socket套接字
//            socket = new Socket(IP,PORT);
//            client.getjButton1().setEnabled(false);
//        }
//        catch (UnknownHostException e1)
//        {
//            e1.printStackTrace();
//        }
//        catch (IOException e1)
//        {
//            e1.printStackTrace();
//        }
        //从服务器端通过socket读取信息
        BufferedReader br = null;
        InputStream in = null;
        try
        {
//            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //把读到的信息显示到TextArea中
            while (socket!=null && !socket.isClosed())
            {
                String ip = socket.getInetAddress().getHostAddress();
                str.append(ip+"\t");
                in = socket.getInputStream();
                byte [] buf = new byte[1024];
                int len = in.read(buf);
                str.append(new String(buf,0,len));
//                str = br.readLine();
//                client.getjTextArea1().append(str + "\n");
                //建一个新的文本文档，用于存储从服务器读到的信息
                File file = new File("/Users/apple/demo.txt");
                if(!file.exists())
                file.createNewFile();
                PrintWriter out = null;
                String date = null;
                //修改时间显示的格式
                SimpleDateFormat sdf = null;

                try
                {
                    //把读到的信息，写到到文本文件中存储起来
                    out = new PrintWriter(new FileOutputStream(file, true));
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    date = sdf.format(new Date());
                    out.println(date+"\t"+str);
                    System.out.println(str);
                    out.flush();
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    out.close();
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //进行流关闭处理，先进行判断，然后再关闭
        finally
        {
            try
            {
                if(br != null)
                {
                    br.close();
                    br =null;
                }
                if(socket != null)
                {
                    socket.close();
                    socket = null;
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
//    public static void main(String args[]){
//            ConnectListener listener = new ConnectListener();
//        listener.run();
//        }
}
