/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De03.Cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1040);
            System.out.println("Dang doi...");
            Socket myServer = server.accept();
            DataInputStream dis = new DataInputStream(myServer.getInputStream());
            DataOutputStream dos = new DataOutputStream(myServer.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String send, receive;
            while(true){
                receive=dis.readUTF();
                if(receive.equalsIgnoreCase("Tam biet")){                   
                    return;
                }else{
                    System.out.println("Client>>" +receive);
                    System.out.println("Server>>");
                    send=sc.nextLine();
                    if(send.equalsIgnoreCase("Tam biet")){
                        dos.writeUTF(send);
                        return;
                    }else{
                        dos.writeUTF(send);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
