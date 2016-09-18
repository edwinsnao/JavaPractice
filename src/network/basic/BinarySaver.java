package network.basic;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by fazhao on 16/9/18.
 */
public class BinarySaver {
    public static void main(String args[]){
        try {
//            URL url = new URL("www.baidu.com");
            URL url = new URL("http://www.baidu.com");
            saveBinary(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void saveBinary(URL url) {
        try {
            URLConnection uc = url.openConnection();
            int length = uc.getContentLength();
            int offset = 0;
            byte[] data = new byte[length];
//            byte[] data = new byte[100];
            InputStream raw = uc.getInputStream();
            InputStream in = new BufferedInputStream(raw);
            int readed = 0;
            while(offset < length){
                readed = in.read(data,offset,length - offset);
                if(readed == -1) {
                    System.out.println("readed all");
                    break;
                }
                offset += readed;
                System.out.println("readed:"+readed+"bytes ,expected:"+length+"bytes");
            }
            System.out.println("test1");
            in.close();
            System.out.println("test2");
            System.out.println("readed:"+readed+"bytes ,expected:"+length+"bytes");
            if(offset != length) {
                throw new IOException("Only read"+offset+", expected:"+length);
            }
            System.out.println("test3");
            /**
            * 因为baidu首页返回的file是空的，所以就没显示出来
            * */
            String name = url.getFile();
            System.out.println(name);
            name = name.substring(name.lastIndexOf("/")+1);
            System.out.println(name);
            System.out.println("test4");
//            FileOutputStream out = new FileOutputStream(name);
//            out.write(data);
//            out.flush();
//            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
