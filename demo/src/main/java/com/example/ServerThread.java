package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    protected int number;
    protected Socket socket;

    public ServerThread(int number, Socket socket) {
        this.number = number;
        this.socket = socket;
    }

    @Override
    public void run(){

        try {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

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
                        
                        exit = false;
                    }
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
