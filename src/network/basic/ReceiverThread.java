package network.basic;

/**
 * Created by fazhao on 16/9/18.
 */
import java.net.*;
import java.io.*;

class ReceiverThread extends Thread {

    DatagramSocket socket;
    private boolean stopped = false;

    public ReceiverThread(DatagramSocket ds) throws SocketException {
        this.socket = ds;
    }

    public void halt() {
        this.stopped = true;
    }

    public void run() {
        System.out.println("Receiver run");
        byte[] buffer = new byte[65507];
        while (true) {
            if (stopped) return;
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(dp);
                String s = new String(dp.getData(), 0, dp.getLength());
                System.out.println(s);
//                Thread.yield();
            }
            catch (IOException ex) {
                System.err.println(ex);
            }

        }

    }

}

