package DesignPatterns.AbstractFactory;

import DesignPatterns.MyEntity.SmsSender;
import DesignPatterns.MyInterface.Provider;
import DesignPatterns.MyInterface.Sender;

public class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
