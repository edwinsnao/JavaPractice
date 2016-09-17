package c11;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.*;

/**
 * Created by Kings on 2016/4/12.
 */
public class FileDownloadPrac {
//    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
//    public boolean download(final URL url, final Path path) throws ExecutionException, InterruptedException {
//        Future<Path> future = executorService.submit(new Callable<Path>() {
//            @Override
//            public Path call() throws Exception {
//                InputStream is = url.openStream();
//                Files.copy(is,path, StandardCopyOption.REPLACE_EXISTING);
//                return path;
////                return null;
//            }
//        });
//        return future.get()!=null?true:false;
//    }
//    public void close() {
//        executorService.shutdown();
//        try {
//            if(!executorService.awaitTermination(3,TimeUnit.MINUTES)){
//                executorService.shutdown();
//                executorService.awaitTermination(1,TimeUnit.MINUTES);
//            }
//        } catch (InterruptedException e) {
//            executorService.shutdownNow();
//            Thread.currentThread().interrupt();
//            e.printStackTrace();
//        }
//    }
//    prac1
//    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
//    public boolean download(final URL url,Path path) throws ExecutionException, InterruptedException {
//        Future<Path> future = executorService.submit(new Callable<Path>() {
//            @Override
//            public Path call() throws Exception {
//                InputStream is = url.openStream();
//                Files.copy(is,path,StandardCopyOption.REPLACE_EXISTING);
//                return path;
//            }
//        });
//        return future.get()!=null?true:false;
//    }
//
//    public void  close(){
//        executorService.shutdown();
//        try {
//            if(!executorService.awaitTermination(3,TimeUnit.MINUTES)){
//                executorService.shutdown();
//                executorService.awaitTermination(1,TimeUnit.MINUTES);
//            }
//        } catch (InterruptedException e) {
//            executorService.shutdownNow();
//            Thread.currentThread().interrupt();
//            e.printStackTrace();
//        }
//    }

//    preac2
ExecutorService executorService = Executors.newFixedThreadPool(10);
    private boolean download(URL url,Path path) throws ExecutionException, InterruptedException {
        Future<Path> future = executorService.submit(new Callable<Path>() {
            @Override
            public Path call() throws Exception {
                InputStream is = url.openStream();
                Files.copy(is,path,StandardCopyOption.REPLACE_EXISTING);
                return path;
            }
        });
        return future.get()!=null?true:false;
    }

    public void close(){
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(3,TimeUnit.MINUTES)){
                executorService.shutdown();
                executorService.awaitTermination(1,TimeUnit.MINUTES);
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

     public static void main(String[] args) throws MalformedURLException, ExecutionException, InterruptedException {
          FileDownloadPrac downloader = new FileDownloadPrac();
//         downloader.download(new URL("http://www.baidu.com"), Paths.get("G:\\untitled\\src\\c11\\baidu.txt"));
         downloader.download(new URL("http://www.baidu.com"),Paths.get("E:\\baidu.txt"));
         downloader.download(new URL("http://www.sina.com.cn"), Paths.get("G:\\untitled\\src\\c11\\sina.txt"));
         downloader.close();
         }
}
