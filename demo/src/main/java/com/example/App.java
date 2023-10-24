package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        try {
            ServerSocket servsock= new ServerSocket(3000);

            while(true){
                Socket s=servsock.accept();

                ServerThread thread=new ServerThread(10, s);
                thread.start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
