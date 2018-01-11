package DesignPatterns;

import DesignPatterns.AbstractFactory.SendMailFactory;
import DesignPatterns.Builder.BuilderFactory;
import DesignPatterns.Factory.MultiSendFactory;
import DesignPatterns.Factory.SendFactory;
import DesignPatterns.MyInterface.Provider;
import DesignPatterns.MyInterface.Sender;

// 设计模式驱动类
public class DesignDriver {
    public static void main(String[] args) {
        Test test = new Test();
        /*test.method();
        test.method2();
        test.method3();*/
        test.method4();
    }
}
class Test{
    // 工厂模式
    void method(){
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produce("mail");
        sender.Send();
    }
    // 多个工厂方法模式
    void method2(){
        MultiSendFactory sendFactory = new MultiSendFactory();
        Sender sender = sendFactory.produceSms();
        sender.Send();
    }
    // 抽象工厂模式
    void method3(){
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }

    // 建造者模式
    void method4(){
        BuilderFactory builderFactory = new BuilderFactory();
        builderFactory.produceMailSender(3);
    }
}
