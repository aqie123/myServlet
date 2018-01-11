package DesignPatterns.AbstractFactory;

import DesignPatterns.MyEntity.MailSender;
import DesignPatterns.MyInterface.Provider;
import DesignPatterns.MyInterface.Sender;

public class SendMailFactory implements Provider {

    @Override
    public Sender produce(){
        return new MailSender();
    }
}
