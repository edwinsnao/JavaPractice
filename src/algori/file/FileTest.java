package algori.file;

import java.io.*;

/**
 * Created by fazhao on 16/9/4.
 */
public class FileTest {
    public static void main(String args[]) throws IOException {
        File file = new File("/Users/apple/demo.txt");
        /**
        * create
        * */
        PrintWriter print = null;
        FileReader reader = null;
        BufferedReader br = null;
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            /**
             * write
             * */
            print = new PrintWriter(new FileOutputStream(file,true));
            print.print("hello");
            /**
            * 如果不加入这一行就不会写入文件
            * */
            print.flush();
//            FileReader reader = new FileReader(file);
            /**一样
            * /Users/apple/demo.txt
            * */
            String path = file.getPath();
            String path1 = file.getAbsolutePath();

            /**
            * 一样
             /Users/apple  返回了文件夹
            * */
            File path2 = file.getParentFile();
            String path3 = file.getParent();
            System.out.println(path);
            System.out.println(path1);
            System.out.println(path2.getAbsolutePath());
            System.out.println(path3);
            /**
            * same
            * */
            reader = new FileReader(path);
//            FileReader reader = new FileReader(file);
            br = new BufferedReader(reader);
            String s = null;
            while((s = br.readLine())!=null)
                System.out.println(s);
            System.out.println(reader.read());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            print.close();
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            reader.close();
            br.close();
        }


        /**
        * delete
        * */
//        if (file.exists())
//            file.delete();
        System.out.println(file.getAbsolutePath());
    }
}
