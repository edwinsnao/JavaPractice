package network.cache;

/**
 * Created by fazhao on 16/9/18.
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

public class SimpleCacheRequest extends CacheRequest {

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    public OutputStream getBody() throws IOException {
        return out;
    }

    public void abort() {
        out = null;
    }

    public byte[] getData() {
        if (out == null) return null;
        else return out.toByteArray();
    }

}

