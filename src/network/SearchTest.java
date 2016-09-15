package network;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by fazhao on 16/9/15.
 */
public class SearchTest {

        public static void main(String[] args) {

            String target = "arts";

//            for (int i = 0; i < args.length; i++) {
//                target += args[i] + " ";
//            }
            target = target.trim();
            QueryString query = new QueryString("search", target);
            try {
                URL u = new URL("http://search.dmoz.org/cgi-bin/search?" + query);
                InputStream in = new BufferedInputStream(u.openStream());
                InputStreamReader theHTML = new InputStreamReader(in);
                int c;
                while ((c = theHTML.read()) != -1) {
                    System.out.print((char) c);
                }
            }
            catch (MalformedURLException ex) {
                System.err.println(ex);
            }
            catch (IOException ex) {
                System.err.println(ex);
            }

        }

}

class QueryString {

    private StringBuffer query = new StringBuffer();

    public QueryString(String name, String value) {
        encode(name, value);
    }

    public synchronized void add(String name, String value) {
        query.append('&');
        encode(name, value);
    }

    private synchronized void encode(String name, String value) {
        try {
            query.append(URLEncoder.encode(name, "UTF-8"));
            query.append('=');
            query.append(URLEncoder.encode(value, "UTF-8"));
        }
        catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }
    }

    public String getQuery() {
        return query.toString();
    }

    public String toString() {
        return getQuery();
    }

}