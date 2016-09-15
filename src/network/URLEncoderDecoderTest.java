package network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by fazhao on 16/9/15.
 */
public class URLEncoderDecoderTest {

    public static void main(String[] args) {
        System.out.println("Encode");
        String input = "http://www.altavista.com/cgi-bin/query?pg=q&kl=XX&stype=stext&q=+\"Java Network Programming\"";
        System.out.println(input);
        String output = null;
        try {
            output = URLEncoder.encode(input,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(output);

        String s = URLEncoder.encode("http");
        s += "://";
        s += URLEncoder.encode("www.altavista.com");
        s += "/";
        s += URLEncoder.encode("cgi-bin");
        s += "/";
        s += URLEncoder.encode("query");
        s += "?";
        s += URLEncoder.encode("pg");
        s += "=";
        s += URLEncoder.encode("q");
        s += "&";
        s += URLEncoder.encode("kl");
        s += "=";
        s += URLEncoder.encode("XX");
        s += "&";
        s += URLEncoder.encode("stype");
        s += "=";
        s += URLEncoder.encode("stext");
        s += "&";
        s += URLEncoder.encode("q");
        s += "=";
        s += URLEncoder.encode("\"Java Network Programming\"");
        System.out.println(s);


        System.out.println("Decode");
        String input1 = "http://www.altavista.com/cgi-bin/query?pg=q&kl=XX&stype=stext&q=%2B%22Java+Network+Programming%22&search.x=30&search.y=7";
        System.out.println(input1);
        try {
            String output1 = URLDecoder.decode(input1,"UTF-8");
            System.out.println(output1);
        }
        catch (Exception e) {
            System.err.println("Malformed URL");
        }
    }



}
