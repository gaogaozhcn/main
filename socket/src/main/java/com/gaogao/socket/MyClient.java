package com.gaogao.socket;

/**
 * Created by gaohaiming on 16/10/26.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {

    public static void main(String[] args) throws Exception {
        Socket client = new Socket(InetAddress.getLocalHost(), 5678);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = wt.readLine();

            out.println(str);
            out.flush();
            if (str.equals("end")) {
                break;
            }
            System.out.println("server "+client.getRemoteSocketAddress()+"say:");
            System.out.println(in.readLine());
        }
        client.close();
    }
}