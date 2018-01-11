package DesignPatterns.Builder;

import DesignPatterns.MyEntity.MailSender;
import DesignPatterns.MyEntity.SmsSender;
import DesignPatterns.MyInterface.Sender;

import java.util.ArrayList;
import java.util.List;

// 建造者模式
public class BuilderFactory {
    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int count){
        for(int i=0;i<count;i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }
}
