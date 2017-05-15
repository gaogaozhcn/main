package com.gaogao.socket;

/**
 * Created by gaohaiming on 16/10/26.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerPlus extends Thread {
    private Socket client;

    public MyServerPlus(Socket c) {
        this.client = c;
        String clientInfo=client.getRemoteSocketAddress().toString();
        System.out.println(clientInfo+" accepted");
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            char chars[] = new char[1024];
            // Mutil User but can't parallel
            BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String str = in.readLine();
                StringBuilder builder = new StringBuilder();
                int len;
                while ((len=in.read(chars)) != -1) {
                    builder.append(new String(chars, 0, len));
                }
                String clientInfo=client.getRemoteSocketAddress().toString();
                System.out.println(clientInfo+" say:");
                System.out.println(builder);
                out.println(wt.readLine());
                out.flush();
                if (str.equals("end"))
                    break;
            }
            client.close();
        } catch (IOException ex) {
        } finally {
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5678);
        while (true) {
            // transfer location change Single User or Multi User

            MyServerPlus mc = new MyServerPlus(server.accept());
            mc.start();
        }
    }
}
