package network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by fazhao on 16/9/15.
 */
public class URLEquality {

    public static void main (String[] args) {

        try {
            /**
            * URL的equals除了重写了像String一样比较两个字符是否相等还
             * protected boolean sameFile(URL u1, URL u2) {
             // Compare the protocols.
             if (!((u1.getProtocol() == u2.getProtocol()) ||
             (u1.getProtocol() != null &&
             u1.getProtocol().equalsIgnoreCase(u2.getProtocol()))))
             return false;

             // Compare the files.
             if (!(u1.getFile() == u2.getFile() ||
             (u1.getFile() != null && u1.getFile().equals(u2.getFile()))))
             return false;

             // Compare the ports.
             int port1, port2;
             port1 = (u1.getPort() != -1) ? u1.getPort() : u1.handler.getDefaultPort();
             port2 = (u2.getPort() != -1) ? u2.getPort() : u2.handler.getDefaultPort();
             if (port1 != port2)
             return false;

             // Compare the hosts.
             if (!hostsEqual(u1, u2))
             return false;

             return true;
             }
             逐一比较url的
            *
            * */
            URL ibiblio = new URL("http://www.ibiblio.org/");
            URL metalab = new URL("http://metalab.unc.edu/");
            URL baidu = new URL("http://www.baidu.com/");
            URLConnection uc = baidu.openConnection();
            System.out.println(uc.getRequestProperties());
            System.out.println("URL:" + uc.getURL());
            System.out.println("ContentEncoding:" + uc.getContentEncoding());
            System.out.println("Content:" + uc.getContent());
            System.out.println("ContentType:" + uc.getContentType());
            System.out.println("ConnectTimeout:" + uc.getConnectTimeout());
            System.out.println("Connect-Length:" + uc.getContentLength());
            System.out.println("Date:" + (uc.getDate()));
            System.out.println("inPut:" + uc.getDoInput());
            System.out.println("OutPut:" + uc.getDoOutput());
            System.out.println("ReadTimeOut:" + uc.getReadTimeout());
            System.out.println("ConnectTimeOut:" + uc.getConnectTimeout());
            System.out.println("LastModified:" + (uc.getLastModified()));
            /**
            * 两个地址是一样的
             * host metalab.unc.edu
             metalab.unc.edu has address 152.19.134.40
             metalab.unc.edu mail is handled by 30 aspmx3.googlemail.com.
             metalab.unc.edu mail is handled by 30 aspmx4.googlemail.com.
             metalab.unc.edu mail is handled by 30 aspmx5.googlemail.com.
             metalab.unc.edu mail is handled by 20 alt1.aspmx.l.google.com.
             metalab.unc.edu mail is handled by 20 alt2.aspmx.l.google.com.
             metalab.unc.edu mail is handled by 10 aspmx.l.google.com.
             metalab.unc.edu mail is handled by 30 aspmx2.googlemail.com.
             MacBook-Pro:untitled fazhao$ host www.ibiblio.org
             www.ibiblio.org has address 152.19.134.40
             www.ibiblio.org has IPv6 address 2610:28:3090:3000::bad:cafe:23
             www.ibiblio.org mail is handled by 20 alt1.aspmx.l.google.com.
             www.ibiblio.org mail is handled by 20 alt2.aspmx.l.google.com.
             www.ibiblio.org mail is handled by 10 aspmx.l.google.com.
             www.ibiblio.org mail is handled by 30 aspmx2.googlemail.com.
             www.ibiblio.org mail is handled by 30 aspmx3.googlemail.com.
             www.ibiblio.org mail is handled by 30 aspmx4.googlemail.com.
             www.ibiblio.org mail is handled by 30 aspmx5.googlemail.com.
            * */
            if (ibiblio.equals(metalab)) {
                System.out.println(ibiblio + " is the same as " + metalab);
            }
            else {
                System.out.println(ibiblio + " is not the same as " + metalab);
            }
        }
        catch (MalformedURLException ex) {
            System.err.println(ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
