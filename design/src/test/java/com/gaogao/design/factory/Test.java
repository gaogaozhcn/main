package com.gaogao.design.factory;

/**
 * Created by gaohaiming on 16/9/10.
 */
public class Test {
    public static void main(String[] args) {
        Provider provider=new SmsSenderFactory();
        Sender sender=provider.produce();
        sender.send();
    }
}
