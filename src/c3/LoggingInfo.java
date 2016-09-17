package c3;

import java.util.Date;

/**
 * Created by Kings on 2016/4/21.
 */
public class LoggingInfo implements java.io.Serializable
{
    private Date loggingDate = new Date();
    public static String uid;
    private transient String pwd;

    LoggingInfo(String user, String password)
    {
        uid = user;
        pwd = password;
    }
    public String toString()
    {
        String password=null;
        if(pwd == null)
        {
            password = "NOT SET";
        }
        else
        {
            password = pwd;
        }
        return "logon info: \n   " + "user: " + uid +
                "\n   logging date : " + loggingDate.toString() +
                "\n   password: " + password;
    }
}
