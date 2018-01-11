package DesignPatterns.MyEntity;

import DesignPatterns.MyInterface.Sender;

public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mail sender!");
    }
}
