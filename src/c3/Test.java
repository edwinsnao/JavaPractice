package c3;

import java.io.*;

import static com.oracle.jrockit.jfr.Transition.To;

/**
 * Created by Kings on 2016/4/21.
 */
public class Test {

    public static void main(String[] args) {
        LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");
        System.out.println("Before");
        System.out.println(logInfo.toString());
        try {
            ObjectOutputStream o = new ObjectOutputStream(
                    new FileOutputStream("logInfo.out"));
            o.writeObject(logInfo);
            o.close();
            System.out.println("After");
            logInfo.uid = "Test";
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("logInfo.out"));
            logInfo = (LoggingInfo) in.readObject();
            System.out.println(logInfo.toString());
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}

