package session;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MyURLEncoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Test t = new Test();
        t.method();
    }
}
class Test{
    // url加密
    void method() throws UnsupportedEncodingException {
        String str = "啊切";
        str = URLEncoder.encode(str,"utf-8"); // utf-8 一个中文字符三个字节 Ox->%
        System.out.println(str);

        str = URLDecoder.decode(str,"utf-8");
        System.out.println(str);
    }
}
