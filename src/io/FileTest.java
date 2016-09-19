package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fazhao on 16/9/19.
 */
public class FileTest {
    public static void main(String args[]) {

        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println(fileSystem.getSeparator());
        for (Path root : fileSystem.getRootDirectories()){
            System.out.println(root);
        }

        Path source = Paths.get("/Users/apple/test1");
        Path source1 = FileSystems.getDefault().getPath("/Users/apple/");
        System.out.println(source);
        System.out.println(source.getNameCount());
        System.out.println(source.getFileName());
        /**
        * 是路径名字
        * */
        System.out.println(source.getName(0));
        System.out.println(source.getName(1));
        System.out.println(source.getName(2));
        System.out.println(source1);
        /**
        * file:///Users/apple/
        * */
        System.out.println(source.toUri());
//        System.out.println(FileSystems.getFileSystem(source.toUri()));
        System.out.println(source.toAbsolutePath());
        System.out.println(source.toFile());

        Path sc = Paths.get("/Users/apple/Movies/test");
        Path sc1 = Paths.get("/Users/apple/Movies/demo");
        Path target1 = Paths.get("/Users/apple/test");
        Path target = FileSystems.getDefault().getPath("/Users/apple/Movies/test3");
        String line1 = "Hello";
        String line2 = "World";
        String line3 = "World";
        Charset charset = Charset.forName("US-ASCII");
        /**
        * UTF-8
        * */
        Charset charset1 = Charset.defaultCharset();
        System.out.println(charset);
        System.out.println(charset1);
        List<String> lines = Arrays.asList(line1,line2,line3);
        List<String> read = null;
        try {
//            File file = new File("/Users/apple/Movies/test");
//            if(file.exists()) {
//                return;
//            }
//            else
//                file.createNewFile();
            if(Files.notExists(sc))
                Files.createFile(sc);
            Files.copy(sc,target, StandardCopyOption.REPLACE_EXISTING);
            Files.move(sc,target1,StandardCopyOption.ATOMIC_MOVE);
            Files.write(sc1,lines,charset);
            Files.delete(target1);
            read = Files.readAllLines(sc1,charset);
            if(read != null)
                for (String s : read) {
                    System.out.println(s);
                }
            File dir = new File("/Users/apple/Movies/hello");
            if(dir.exists()){
                dir.delete();
                return;
            }else{
                dir.mkdir();
            }
            Path tmp = Paths.get("/Users/apple/Movies/hello");
            if(Files.exists(tmp)) {
                Files.delete(tmp);
            }
            Files.createDirectory(tmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path tmp1 = Paths.get("/Users/apple/Movies/demo");
        String msg = "test";
        try(OutputStream outputStream = Files.newOutputStream(tmp1);
            BufferedWriter writer = Files.newBufferedWriter(tmp1,charset,StandardOpenOption.APPEND);
        ) {
            writer.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(InputStream inputStream = Files.newInputStream(tmp1,StandardOpenOption.READ);
            InputStreamReader reader = new InputStreamReader(inputStream,charset)
        ) {
            char[] chars = new char[2];
            /**
            * 影响了下一句没有输出结果
            * */
//            int i = inputStream.read();
//            inputStream.close();
            reader.read(chars);
            System.out.println(chars[0]);
            System.out.println(chars[1]);
            /**
            * 不执行下面这句就不可以继续开另一个reader来读取了
            * */
            reader.close();
            BufferedReader reader1 = Files.newBufferedReader(tmp1);
            String line = reader1.readLine();
            while(line != null){
                System.out.println(line);
                line = reader1.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
