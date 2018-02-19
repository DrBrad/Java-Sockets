package org.theanarch.newproxs;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by brad on 1/17/18.
 */
public class Server {

    public static void main(String args[]){
        new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    ServerSocket serverSocket = new ServerSocket(2020);
                    Socket socket;
                    while((socket = serverSocket.accept()) != null){
                        startSocket(socket);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void startSocket(Socket socket){
        try{

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("pong");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());


            out.flush();
            out.close();
            in.close();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                socket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
