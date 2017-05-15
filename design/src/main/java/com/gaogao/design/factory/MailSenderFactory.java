package com.gaogao.design.factory;

/**
 * Created by gaohaiming on 16/9/10.
 */
public class MailSenderFactory implements Provider{

    public Sender produce() {
        return new MailSender();
    }
}
