package network.basic;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by fazhao on 16/9/18.
 */
public class BinarySaverTest {
    public static void main(String args[]){
        try {
            URL url = new URL("http://www.baidu.com");
            binarySave(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        }

    private static void binarySave(URL url) {
        URLConnection uc = null;
        try {
            uc = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream raw = null;
        try {
            raw = uc.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in = new BufferedInputStream(raw);
        int length = uc.getContentLength();
        byte[] data = new byte[length];
        int readed = 0;
        int offset = 0;
        while (readed < length){
            try {
                readed = in.read(data,offset,length-offset);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(readed == -1)
                break;
            offset+=readed;
            System.out.println("readed:"+readed+"bytes, expected:"+length+"bytes");
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(readed != length)
            try {
                throw  new IOException("readed:"+readed+"bytes, expected:"+length+"bytes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        String name = "/Users/apple/Movies/test1";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(name);
            out.write(data);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
