package com.gaogao.thred;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StackPopLevel;
import sun.applet.Main;

import javax.xml.bind.DatatypeConverter;
import javax.xml.soap.SOAPPart;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by gaohaiming on 2017/2/8.
 */
public class DigestThread extends Thread {
    private String filename;

    public DigestThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha=MessageDigest.getInstance("SHA-256");
            DigestInputStream din=new DigestInputStream(in,sha);
            while (din.read()!=-1);
            din.close();
            byte[] digest=sha.digest();
            StringBuilder result=new StringBuilder(filename);
            result.append(": ");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t=new DigestThread("/Users/csyy-test/Desktop/vm-win7/WechatIMG4.jpeg");
       // t.start();
//        System.out.println(2.6*1024*1024/260/60*0.06);
        Random random=new Random();
        for(int i=0;i<100;i++){
            int r=random.nextInt(10000);
            System.out.println(r%10);
        }
    }

}
