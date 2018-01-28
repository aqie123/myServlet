package email;

import com.mchange.v2.c3p0.filter.FilterDataSource;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * javaMail 发送邮件
 */
public class MyJavaMail {
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        // sendMail();
        mailAttachment();
    }

    // 发送邮件
    private static void sendMail() throws MessagingException {
        /**
         * 参数一：本次连接配置
         * 参数二：返回对用户名和密码 base64加密的对象
         */
        Properties props = new Properties();
        // 连接的服务器地址
        props.setProperty("mail.host", "smtp.163.com");
        // 指定进行验证登录
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aqie123aqie@163.com","aqie123aqie");
            }
        });
        // 打开调试
        session.setDebug(true);
        // 在本次连接上，创建一封邮件
        MimeMessage mail = new MimeMessage(session);
        // 设置发件人
        mail.setFrom(new InternetAddress("aqie123aqie@163.com"));

        // 设置收件人
        /** 参数一：发送方法
         *  发送TO： A->B
         *  抄送CC： A->B->C
         *  密送BCC: A->B->C
         *  参数二：发送的地址
         */
        mail.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("2924811900@qq.com"));

        // 设置主题
        mail.setSubject("aqie java");
        // 设置邮件内容
        // mail.setContent(" <font color='red'>mail content</font>","text/plain;charset=utf-8");
        mail.setContent(" <font color='red'>mail content</font>","text/html;charset=utf-8");
        Transport.send(mail);
    }

    // 邮箱附件 mailAttachment
    private static void mailAttachment() throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aqie123aqie@163.com","aqie123aqie");
            }
        });
        session.setDebug(true);
        MimeMessage mail = new MimeMessage(session);
        mail.setFrom(new InternetAddress("aqie123aqie@163.com"));
        mail.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("2924811900@qq.com"));
        // 设置主题
        mail.setSubject("aqie java 带附件");
        // 1.设置邮件内容
        // mail.setContent(" <font color='red'>mail content</font>","text/plain;charset=utf-8");
        mail.setContent(" <font color='red'>mail content</font>","text/html;charset=utf-8");
        // 1.1 内容包含附件,附件内容存放在MimeBodyPart对象

        File file = new File("D:\\coreJava\\myServlet\\firstweb\\web\\staticFile\\Uploads\\40\\40\\4e1fc55e-0034-4780-bd83-78a116172dd5avatar2.jpg");
        MimeBodyPart part = new MimeBodyPart();     // 一个附件对象
        DataSource source = new FileDataSource(file);
        DataHandler handler = new DataHandler(source);
        part.setDataHandler(handler);
        // 设置文件名,并设置中文编码
        part.setFileName(MimeUtility.encodeText(file.getName()));

        File file2 = new File("D:\\coreJava\\myServlet\\firstweb\\web\\staticFile\\Uploads\\103\\103\\12d5312d-c094-461d-827f-e2254b04d9fdavatar.jpg");
        MimeBodyPart part2 = new MimeBodyPart();     // 一个附件对象
        DataSource source2 = new FileDataSource(file2);
        DataHandler handler2 = new DataHandler(source2);
        part2.setDataHandler(handler2);
        // 设置文件名,并设置中文编码
        part2.setFileName(MimeUtility.encodeText(file2.getName()));

        // 该对象用于封装多个附件对象(MimeBodyPart对象放入MimeMultipart)
        MimeMultipart multipart = new MimeMultipart();
        // 添加一个附件
        multipart.addBodyPart(part);
        multipart.addBodyPart(part2);
        // MimeMultipart对象放入MimeMessage
        mail.setContent(multipart);
        Transport.send(mail);

    }

}
class MyAuthenticator extends Authenticator{

}
