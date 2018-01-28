package email;

import sun.misc.BASE64Encoder;

public class TestBase64 {
    public static void main(String[] args) {
        // 对任何字符 字节数据进行base64加密
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String email = base64Encoder.encode("aqie123aqie@163.com".getBytes());
        System.out.println(email);
        String password = base64Encoder.encode("eric12345".getBytes());
        System.out.println(password);
    }
}
