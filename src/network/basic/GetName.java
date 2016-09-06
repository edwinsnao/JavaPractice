package network.basic;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by fazhao on 16/9/6.
 */
public class GetName {
    public static void main(String args[]){
        try {
            /**
            * 与host www.baidu.com得到地址一样
            * */
            InetAddress address = InetAddress.getByName("www.baidu.com");
            String ip = address.getHostAddress();
            System.out.println(address);
            Inet4Address address1 = (Inet4Address) Inet4Address.getByName("www.baidu.com");
            System.out.println(address1);
            /**
            * cast wrong?
            * */
//            Inet6Address address2 = (Inet6Address) Inet6Address.getByName("www.baidu.com");
//            System.out.println(address2);
            InetAddress[] allAddress = InetAddress.getAllByName("www.baidu.com");
            for(int i = 0 ; i <allAddress.length;i++)
                System.out.println(allAddress[i]);
            /**
            * Host name
            * */
            InetAddress name = InetAddress.getLocalHost();
            String me = name.getHostName();
            /**
            * Host IP
            * */
            String me1 = name.getHostAddress();
            System.out.println(me);
            System.out.println(me1);
            /**
            * Reverse: Get HostName through IP
            * */
            InetAddress ia = InetAddress.getByName(ip);
            System.out.println(ia);
            System.out.println(ia.getHostName());
            InetAddress ia1 = InetAddress.getByName("192.168.1.103");
            System.out.println(ia1);
            System.out.println(ia1.getHostName());
            InetAddress ia2 = InetAddress.getByName("127.0.0.1");
            System.out.println(ia2);
            System.out.println(ia2.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
