package network.basic;
import java.net.*;
import java.util.Enumeration;


public class IPDemo {

    public static void main(String[] args) {
        try {
            /**
            *里面的参数是根据ifconfig里面的来决定的，
             * 所以mac里面不是eth0而是en0，如果使用eth0则nullpointer
             * 没有网络时会出现nullpointer(en0是wifi)
            * */
//            NetworkInterface eth0 = NetworkInterface.getByName("eth0");
            NetworkInterface eth0 = NetworkInterface.getByName("en0");
            Enumeration address1 = eth0.getInetAddresses();
            while(address1.hasMoreElements())
                System.out.println(address1.nextElement());
            System.out.println(eth0.getDisplayName());

            NetworkInterface lo0 = NetworkInterface.getByName("lo0");
            Enumeration address2 = lo0.getInetAddresses();
            while(address2.hasMoreElements())
                System.out.println(address2.nextElement());
            System.out.println(lo0.getDisplayName());

            /**
            * /127.0.0.1 is loopback address.
             /127.0.0.1 is a global address.
             /127.0.0.1 is a unicast address.
            * */
//            InetAddress address = InetAddress.getByName("127.0.0.1");
            InetAddress address = InetAddress.getByName("192.168.168.105");

            if (address.isAnyLocalAddress()) {
                System.out.println(address + " is a wildcard address.");
            }
            if (address.isLoopbackAddress()) {
                System.out.println(address + " is loopback address.");
            }

            if (address.isLinkLocalAddress()) {
                System.out.println(address + " is a link-local address.");
            }
            else if (address.isSiteLocalAddress()) {
                System.out.println(address + " is a site-local address.");
            }
            else {
                System.out.println(address + " is a global address.");
            }

            if (address.isMulticastAddress()) {
                if (address.isMCGlobal()) {
                    System.out.println(address + " is a global multicast address.");
                }
                else if (address.isMCOrgLocal()) {
                    System.out.println(address
                            + " is an organization wide multicast address.");
                }
                else if (address.isMCSiteLocal()) {
                    System.out.println(address + " is a site wide multicast address.");
                }
                else if (address.isMCLinkLocal()) {
                    System.out.println(address + " is a subnet wide multicast address.");
                }
                else if (address.isMCNodeLocal()) {
                    System.out.println(address
                            + " is an interface-local multicast address.");
                }
                else {
                    System.out.println(address + " is an unknown multicast address type.");
                }

            }
            else {
                System.out.println(address + " is a unicast address.");
            }

        }
        catch (UnknownHostException ex) {
            System.err.println("Could not resolve " + args[0]);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

}
