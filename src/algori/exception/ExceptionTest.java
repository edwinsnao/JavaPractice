package algori.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by fazhao on 16/9/22.
 */
public class ExceptionTest {
    public static void main(String args[]){
        try{

            /**
            * print IO
            * */
            throw new IOException("IOEXception");
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }

        catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO");
        }catch (Exception e){
            System.out.println("Exception");
        }
    }
}
