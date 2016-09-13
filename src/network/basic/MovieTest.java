package network.basic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fazhao on 16/9/13.
 */
public class MovieTest {
        public static void main (String args[]) throws Exception {
            String s = "http://www.dytt8.net/html/tv/hytv/20110829/33924.html";
            MovieTest mt = new MovieTest();
            mt.getUrl(s);
        }
        public List<String> splitString(String str){//将获取到的网页代码用"<"标签隔开
            String[] strs = str.split("<");
            List <String> list = new ArrayList<String>();
            for (int i = 0; i < strs.length; i++) {
                list.add(strs[i]);
            }
            return list;
        }
        public List<String> registFtp(List<String> list){//将列表中存的代码通过判定截取出来"
            List<String> lists = new ArrayList<String>();
            for (String str : list) {
                int begin = str.indexOf("ftp:");//查找以ftp开头的索引位置
                int end = str.indexOf(".rmvb");//查找以rmvb结尾的索引位置

                if(begin!=-1&&end!=-1){//判断取值
                    String tmp = str.substring(begin, end);//截取字符串,由于用了indexOf,没有rmvb结尾
                    tmp = tmp.concat(".rmvb");//加上后缀名rmvb
                    System.out.println(tmp);//打印出所有的地址
                    lists.add(tmp);
                }
            }

            return list;

        }

        public String getUrl(String ftp){  //获取远端网页的html代码
            String str = "";
            try {
                URL url = new URL(ftp);
                URLConnection conn = url.openConnection();
                InputStream in = conn.getInputStream();

                InputStreamReader reader = new InputStreamReader(in, "gbk");
                BufferedReader br = new BufferedReader(reader);
                String data = br.readLine();

                while (data != null) {
                    str = str.concat(data);
                    data = br.readLine();
                }
                br.close();
                in.close();
                MovieTest mt = new MovieTest();
                mt.registFtp(mt.splitString(str));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return str;
        }
}
