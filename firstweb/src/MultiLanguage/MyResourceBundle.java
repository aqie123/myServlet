package MultiLanguage;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyResourceBundle {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // multitext();
        multiTime();
    }

    // 文本国际化
    private static void multitext() throws UnsupportedEncodingException {
        /**
         * 加载不同资源包
         * 1.资源包名称 : 默认指向类路径根目录
         * 2.
         *  / 指向类根目录
         */
        // ResourceBundle bundle =  ResourceBundle.getBundle("MultiLanguage/message", Locale.CHINA);
        ResourceBundle bundle =  ResourceBundle.getBundle("MultiLanguage/message", Locale.US);
        String username = bundle.getString("username");
        username = new String(username.getBytes("ISO8859-1"),"GB2312");
        System.out.println(username);
    }

    // 时间国际化
    private static void multiTime(){
        /**
         * 1.日期格式 (short medium long full)
         * 2.时间格式  (short medium long full)
         * 3.国家local
         */
        // DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT,Locale.CHINA);
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.CHINA);
        DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.US);
        String curDate = df.format(new Date());
        String curDate2 = df2.format(new Date());
        System.out.println(curDate);
        System.out.println(curDate2);
    }
}
