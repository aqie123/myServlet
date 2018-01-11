package DesignPatterns.Factory;

import DesignPatterns.MyEntity.MailSender;
import DesignPatterns.MyEntity.SmsSender;
import DesignPatterns.MyInterface.Sender;

public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
