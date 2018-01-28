package MailRegister;

import java.util.UUID;

/**
 * 工具类
 */
public class WebUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
