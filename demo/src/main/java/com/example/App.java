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
            ServerSocket servsock = new ServerSocket(6000);
            Socket s = servsock.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            int numbertoguess = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
            
            boolean exit = true;

            while (exit == true) {

                String messagereceived = in.readLine();

                int numberfromclient = Integer.parseInt(messagereceived);

                if (numberfromclient < numbertoguess) {
                    out.writeBytes("A" + "\n");
                }

                if (numberfromclient > numbertoguess) {
                    out.writeBytes("AA" + "\n");
                }

                if (numberfromclient == numbertoguess) {
                    out.writeBytes("AAA" + "\n");

                    servsock.close();
                    exit = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
