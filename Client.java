package org.theanarch.newproxc;

import java.io.*;
import java.net.Socket;

/**
 * Created by brad on 1/17/18.
 */
public class Client {

    public static void main(String args[]){
        new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    Socket socket = new Socket("127.0.0.1", 2020);
                    startSocket(socket);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void startSocket(Socket socket){
        try{

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("ping");

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
