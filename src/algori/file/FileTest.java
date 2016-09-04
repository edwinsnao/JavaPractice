package algori.file;

import java.io.File;

/**
 * Created by fazhao on 16/9/4.
 */
public class FileTest {
    public static void main(String args[]){
        File file = new File("/Users/apple/demo.txt");
        /**
        * create
        * */
//        try {
//            file.createNewFile();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /**
        * delete
        * */
        if (file.exists())
            file.delete();
        System.out.println(file.getAbsolutePath());
    }
}
