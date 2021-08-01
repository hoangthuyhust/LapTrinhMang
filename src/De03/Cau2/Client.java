/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De03.Cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket myClient = new Socket("LocalHost", 1040);
            System.out.println("Da ket noi thanh cong voi Client");
            DataInputStream dis = new DataInputStream(myClient.getInputStream());
            DataOutputStream dos = new DataOutputStream(myClient.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String send, receive;
            while(true){
                System.out.println("Client>>");
                send=sc.nextLine();
                dos.writeUTF(send);
                if(send.equalsIgnoreCase("Tam biet")){
                    return;
                }else{
                    receive=dis.readUTF();
                    if(receive.equalsIgnoreCase("Tam biet")){
                        dos.writeUTF(send);
                        return;
                    }else{
                        System.out.println("Server>>"+receive);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
