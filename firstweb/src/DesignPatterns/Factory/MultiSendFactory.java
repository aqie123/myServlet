package DesignPatterns.Factory;

import DesignPatterns.MyEntity.MailSender;
import DesignPatterns.MyEntity.SmsSender;
import DesignPatterns.MyInterface.Sender;

// 多个工厂方法模式  静态工厂方法模式
public class MultiSendFactory {
    /*public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }*/
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
