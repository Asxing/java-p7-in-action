package com.holddie.netty.java.io;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class IOClient {
    public static void main(String[] args) {
        new Thread(
                        () -> {
                            try {
                                Socket socket = new Socket("127.0.0.1", 8080);
                                while (true) {
                                    String string = new Date() + ": hello world";
                                    System.out.println("send message: " + string);
                                    socket.getOutputStream()
                                            .write(string.getBytes(StandardCharsets.UTF_8));
                                    Thread.sleep(2000);
                                }
                            } catch (IOException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        })
                .start();
    }
}
