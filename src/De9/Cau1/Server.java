/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De9.Cau1;

import java.io.DataInputStream;
import java.io.DataOutput;
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
            ServerSocket server = new ServerSocket(1032);
            System.out.println("Dang doi...");
            Socket myServer = server.accept();
            System.out.println("Da ket noi thanh cong voi Client");
            DataInputStream dis = new DataInputStream(myServer.getInputStream());
            DataOutputStream dos = new DataOutputStream(myServer.getOutputStream());
            int thang = dis.read();
            int nam = dis.read();
            String text ="";
            switch(thang){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    text="Thang " + thang+" co 31 ngay";
                    break;
                case 4:
                case 6:
                case 9:
                case 11: 
                    text="Thang " + thang+" co 30 ngay";
                    break;
                case 2:
                    if((nam%4==0 && nam%100!=0) || nam%400==0){
                        text="Thang 2 co 29 ngay";
                    }else{
                        text="Thang 2 co 28 ngay";
                    }
                    break;
            }
            dos.writeUTF(text);
            myServer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
