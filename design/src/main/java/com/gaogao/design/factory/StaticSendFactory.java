package com.gaogao.design.factory;

/**
 * 静态工厂
 * Created by gaohaiming on 16/9/10.
 */
public class StaticSendFactory {

    public static MailSender produceMail() {
        return new MailSender();
    }

    public static SmsSender produceSms() {
        return new SmsSender();
    }
}
