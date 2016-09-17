package network;

/**
 * Created by fazhao on 16/9/16.
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class UdpPoke {

    public static final int port = 13;
    public static final String address = "rama.poly.edu";
    private int             bufferSize; // in bytes
    private DatagramSocket socket;
    private DatagramPacket outgoing;

    public UdpPoke(InetAddress host, int port, int bufferSize,
                   int timeout) throws SocketException {

        outgoing = new DatagramPacket(new byte[1], 1, host, port);
        this.bufferSize = bufferSize;
        socket = new DatagramSocket(0);
//        socket = new DatagramSocket(port);
        socket .connect(host, port); // requires Java 2
        socket .setSoTimeout(timeout);

    }

    public UdpPoke(InetAddress host, int port, int bufferSize)
            throws SocketException {
        this(host, port, bufferSize, 30000);
    }

    public UdpPoke(InetAddress host, int port)
            throws SocketException {
        this(host, port, 8192, 30000);
    }

    public byte[] poke() throws IOException {

        byte[] response = null;
        try {
            socket .send(outgoing);
            DatagramPacket incoming
                    = new DatagramPacket(new byte[bufferSize], bufferSize);
            // next line blocks until the response is received
            socket .receive(incoming);
            int numBytes = incoming.getLength();
            response = new byte[numBytes];
            System.arraycopy(incoming.getData(), 0, response, 0, numBytes);
        }
        catch (IOException ex) {
            // response will be null
        }

        // may return null
        return response;
    }

    public static void main(String[] args) {

        InetAddress host;
        try {
            host = InetAddress.getByName(address);
        }
        catch (Exception ex) {
            System.out.println("Usage: java UdpPoke host port");
            return;
        }

        try {
            UdpPoke poker = new UdpPoke(host, port);
            byte[] response = poker.poke();
            if (response == null) {
                System.out.println("No response within allotted time");
                return;
            }
            String result = "";
            try {
                result = new String(response, "ASCII");
            }
            catch (UnsupportedEncodingException e) {
                // try a different encoding
                result = new String(response, "8859_1");
            }
            System.out.println(result);
        }
        catch (Exception ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }

    }  // end main

}

