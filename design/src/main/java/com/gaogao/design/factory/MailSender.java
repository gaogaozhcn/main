package com.gaogao.design.factory;

/**
 * Created by gaohaiming on 16/9/10.
 */
public class MailSender implements Sender {

    public void send() {
        System.out.println("send a mail");
    }
}
