package network;

/**
 * Created by fazhao on 16/9/15.
 */

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GetTest {

    /**
     * 下载网页，相当于GET方法
     * */
    public static void main (String[] args){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd-hh:mm:ss");
            try {
                /**
                 * 不可以不加http://
                 * */
                /**
                 * 其实是HTTPRULCONNECTION！?
                 * sun.net.www.protocol.http.HttpURLConnection$HttpInputStream
                 * */
                URL u = new URL("http://www.baidu.com");
//                URL u = new URL("http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=NetworkInterface.getByName(%22eth0%22)%3B&step_word=&hs=0&pn=0&spn=0&di=307385993651&pi=&rn=1&tn=baiduimagedetail&is=&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=3762154788%2C3152545778&os=372187354%2C332776255&simid=4186132155%2C357270607&adpicid=0&ln=950&fr=&fmq=1473912131785_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=15&oriquery=&objurl=http%3A%2F%2Fs15.sinaimg.cn%2Fmiddle%2F616e189f4a41a98e6dbae%26690&fromurl=ippr_z2C%24qAzdH3FAzdH3Fks52_z%26e3Bftgw_z%26e3Bv54_z%26e3BvgAzdH3FfAzdH3Fks52_1vvcvv8da8a872eb_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0");
                Object o = u.getContent();
                System.out.println(o.getClass().getName());
                URLConnection uc = u.openConnection();
                /**
                * getRequestProperties和getRequestProperty必须放在最前，
                 * 就是要放在getURL等其他getter方法之前
                 * 否则会出现IllegalStateException:Already connect
                * */
                Map requests = uc.getRequestProperties();
                Set key = requests.keySet();
                Iterator iterator = key.iterator();
                while (iterator.hasNext()){
                    String val = (String) iterator.next();
                    System.out.println("RequestProperties:" + uc.getRequestProperty(val));
                }
                System.out.println("RequestProperties:" + uc.getRequestProperties());
                System.out.println("URL:" + uc.getURL());
                System.out.println("ContentEncoding:" + uc.getContentEncoding());
                System.out.println("Content:" + uc.getContent());
                System.out.println("ContentType:" + uc.getContentType());
                System.out.println("ConnectTimeout:" + uc.getConnectTimeout());
                System.out.println("Connect-Length:" + uc.getContentLength());
                System.out.println("Date:" + format.format(uc.getDate()));
                System.out.println("inPut:" + uc.getDoInput());
                System.out.println("OutPut:" + uc.getDoOutput());
                System.out.println("ReadTimeOut:" + uc.getReadTimeout());
                System.out.println("ConnectTimeOut:" + uc.getConnectTimeout());
                System.out.println("LastModified:" + format.format(uc.getLastModified()));
                    System.out.println("Permission:" + uc.getPermission());
                    System.out.println("Expiration:" + uc.getExpiration());
                    System.out.println("useCaches:" + uc.getUseCaches());
                    uc.connect();
                    InputStream in = u.openStream();
                    in = new BufferedInputStream(in);
                    BufferedReader r = new BufferedReader(new InputStreamReader(in));
                    int c;
                    int i = 0;
                    while ((c = r.read()) != -1) {
                        if (i++ == 50) {
                            System.out.println("");
                            i = 0;
                        }
                        System.out.print((char) c);
                    }
            }
            catch(MalformedURLException ex){
                }
            catch(IOException ex){
                    System.err.println(ex);
                }
    }

}

