/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1025);
            System.out.println("Dang doi...");
            Socket myServer = server.accept();
            System.out.println("Da ket noi thanh cong voi  Client");
            DataInputStream dis = new DataInputStream(myServer.getInputStream());
            DataOutputStream dos = new DataOutputStream(myServer.getOutputStream());
            int n = dis.read();
            String sendText;
            if(n%2==0){
               sendText="La so chan";
            }
            else{
                sendText="La so le";
            }
            dos.writeUTF(sendText);
            server.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
