package network.basic;
import java.net.*;

public class IPDemo {

    public static void main(String[] args) {

        try {
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
        }

    }

}
