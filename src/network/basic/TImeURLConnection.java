package network.basic;

import java.io.IOException;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by fazhao on 16/9/10.
 */
public class TImeURLConnection extends URLConnection {
    private Socket connection = null;
    public final static int DEFAULT_PORT = 37;

    /**
     * Constructs a URL connection to the specified URL. A connection to
     * the object referenced by the URL is not created.
     *
     * @param url the specified URL.
     */
    protected TImeURLConnection(URL url) {
        super(url);
    }

    public String getContentType(){
        return "application/x-time";
    }

    public Object getContent() throws IOException{
        ContentHandler ch = new x_time();
        return ch.getContent(this);
    }

    public Object getContent(Class[] classes) throws IOException {
        ContentHandler ch = new x_time();
        return ch.getContent(this, classes);
    }
    public InputStream getInputStream() throws IOException {
        if (!connected) this.connect();
        return this.connection.getInputStream();
    }
    @Override
    public void connect() throws IOException {
        if (!connected) {
            int port = url.getPort();
            if ( port < 0) {
                port = DEFAULT_PORT;
            }
            this.connection = new Socket(url.getHost(), port);
            this.connected = true;
        }
    }
}

class x_time extends ContentHandler {

    public Object getContent(URLConnection uc) throws IOException {

        Class[] classes = new Class[1];
        classes[0] = Date.class;
        return this.getContent(uc, classes);

    }

    public Object getContent(URLConnection uc, Class[] classes)
            throws IOException {

        InputStream in = uc.getInputStream();
        for (int i = 0; i < classes.length; i++) {
            if (classes[i] == InputStream.class) {
                return in;
            }
            else if (classes[i] == Long.class) {
                long secondsSince1900 = readSecondsSince1900(in);
                return new Long(secondsSince1900);
            }
            else if (classes[i] == Date.class) {
                long secondsSince1900 = readSecondsSince1900(in);
                Date time = shiftEpochs(secondsSince1900);
                return time;
            }
            else if (classes[i] == Calendar.class) {
                long secondsSince1900 = readSecondsSince1900(in);
                Date time = shiftEpochs(secondsSince1900);
                Calendar c = Calendar.getInstance();
                c.setTime(time);
                return c;
            }
            else if (classes[i] == String.class) {
                long secondsSince1900 = readSecondsSince1900(in);
                Date time = shiftEpochs(secondsSince1900);
                return time.toString();
            }
        }

        return null; // no requested type available

    }

    private long readSecondsSince1900(InputStream in)
            throws IOException {

        long secondsSince1900 = 0;
        for (int j = 0; j < 4; j++) {
            secondsSince1900 = (secondsSince1900 << 8) | in.read();
        }
        return secondsSince1900;

    }

    private Date shiftEpochs(long secondsSince1900) {

        // The time protocol sets the epoch at 1900, the Java Date class
        //  at 1970. This number converts between them.
        long differenceBetweenEpochs = 2208988800L;

        long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
        long msSince1970 = secondsSince1970 * 1000;
        Date time = new Date(msSince1970);
        return time;

    }
}
